package com.epam.newsmanagement.dao.impl;

import static org.apache.commons.dbutils.DbUtils.closeQuietly;
import static org.springframework.jdbc.datasource.DataSourceUtils.doGetConnection;
import static org.springframework.jdbc.datasource.DataSourceUtils.releaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.epam.newsmanagement.dao.INewsDao;
import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.entity.SearchCriteria;
import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.DaoException;

/**
 * The Class NewsDaoImpl.
 *
 * @author Dzmitry Hrushetski
 */
public class NewsDaoImpl implements INewsDao {
	private static final String SQL_ADD_NEWS = "INSERT INTO NEWS (NEWS.TITLE, NEWS.SHORT_TEXT, NEWS.FULL_TEXT, NEWS.CREATION_DATE, NEWS.MODIFICATION_DATE) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_DELETE_NEWS = "DELETE FROM NEWS WHERE NEWS.NEWS_ID = ?";
	private static final String SQL_JOIN_NEWS_NEWS_AUTHOR = " INNER JOIN NEWS_AUTHOR ON NEWS_AUTHOR.NEWS_ID = NEWS.NEWS_ID ";
	private static final String SQL_AUTHOR_ID = " NEWS_AUTHOR.AUTHOR_ID = ";
	private static final String SQL_AND_PART = " AND ";
	private static final String SQL_JOIN_NEWS_NEWS_TAG = " INNER JOIN NEWS_TAG ON NEWS_TAG.NEWS_ID = NEWS.NEWS_ID ";
	private static final String SQL_TAG_ID = " NEWS_TAG.TAG_ID IN ( ";
	private static final String COMMA = ", ";
	private static final String SQL_TAG_ID_END_PART = ")";
	private static final String SQL_PART_1 = "select * from ( select /* + FIRST_ROWS(";
	private static final String SQL_PART_2 = ") */ a.*, ROWNUM rnum from (";
	private static final String SQL_FIND_NEWS_BY_SEARCH_CRITERIA_PART_1 = "SELECT DISTINCT NEWS.NEWS_ID, NEWS.TITLE, NEWS.SHORT_TEXT, NEWS.FULL_TEXT, NEWS.CREATION_DATE, NEWS.MODIFICATION_DATE FROM NEWS ";
	private static final String SQL_WHERE_PART = " WHERE ";
	private static final String SQL_FIND_NEWS_BY_SEARCH_CRITERIA_PART_2 =" ORDER BY NEWS.CREATION_DATE DESC"; 
	private static final String SQL_PART_3 = ") a where ROWNUM <=";
	private static final String SQL_PART_4 = ") where rnum  >=";
		
	private static final String NEWS_ID = "NEWS_ID";
	private static final String TITLE = "TITLE";
	private static final String SHORT_TEXT = "SHORT_TEXT";
	private static final String FULL_TEXT = "FULL_TEXT";
	private static final String CREATION_DATE = "CREATION_DATE";
	private static final String MODIFICATION_DATE = "MODIFICATION_DATE";
	
	private static final int FIRST_COLUMN = 1;
	
	private StringBuffer createdSQL = new StringBuffer();
	private DataSource dataSource;
	
	/**
	 * Gets the data source.
	 *
	 * @return the data source
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * Sets the data source.
	 *
	 * @param dataSource the new data source
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.INewsDao#findNewsBySearchCriteria(com.epam.newsmanagement.entity.SearchCriteria, int, int)
	 */
	@Override
	public List<News> findNewsBySearchCriteria(SearchCriteria searcCriteria, int beginIndex, int countNews) throws DaoException {
		List<News> newsList = new ArrayList<News>();
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		News news=null;
		
		createSqlBySearchCriteria(searcCriteria, beginIndex, countNews);
		
		try {
			connection = doGetConnection(dataSource);
			st = connection.createStatement();
			rs = st.executeQuery(createdSQL.toString());
			
			while (rs.next()) {
				news = new News();
				news.setNewsId(rs.getLong(NEWS_ID));
				news.setTitle(rs.getString(TITLE));
				news.setShortText(rs.getString(SHORT_TEXT));
				news.setFullText(rs.getString(FULL_TEXT));
				news.setCreationTimestamp(rs.getTimestamp(CREATION_DATE));
				news.setModificationDate(rs.getDate(MODIFICATION_DATE));
				newsList.add(news);
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error, TagDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(st);
			releaseConnection(connection, dataSource);
		}
		return newsList;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.INewsDao#addNews(com.epam.newsmanagement.entity.News)
	 */
	@Override
	public void addNews(News news) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_ADD_NEWS, new String [] {NEWS_ID});
			ps.setString(1, news.getTitle());
			ps.setString(2, news.getShortText());
			ps.setString(3, news.getFullText());
			ps.setTimestamp(4, news.getCreationTimestamp());
			ps.setDate(5, news.getModificationDate());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			while (rs.next()) {
				news.setNewsId(rs.getLong(FIRST_COLUMN));
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error, NewsDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.INewsDao#deleteNews(java.lang.Long)
	 */
	@Override
	public void deleteNews(Long newsId) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_DELETE_NEWS);
			ps.setLong(1,newsId);
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException("Database error, NewsDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
	}
	
	private void createSqlBySearchCriteria(SearchCriteria searcCriteria, int beginIndex, int countNews) {
		Author author = searcCriteria.getAuthor();
		List<Tag> tagList = searcCriteria.getTagList();
		boolean whereFlag = false; 
		
		createdSQL.append(SQL_PART_1);
		createdSQL.append(String.valueOf(countNews));
		createdSQL.append(SQL_PART_2);
		createdSQL.append(SQL_FIND_NEWS_BY_SEARCH_CRITERIA_PART_1);
		if(author!=null) {
			whereFlag = true;
			createdSQL.append(SQL_JOIN_NEWS_NEWS_AUTHOR);
		}
		if(tagList!=null) {
			whereFlag = true;
			createdSQL.append(SQL_JOIN_NEWS_NEWS_TAG);
		}
		if(whereFlag) {
			createdSQL.append(SQL_WHERE_PART);
		}
		if(author!=null) {
			createdSQL.append(SQL_AUTHOR_ID);
			createdSQL.append(String.valueOf(author.getAuthorId()));
		}
		if(tagList!=null) {
			if(author!=null) {
				createdSQL.append(SQL_AND_PART);
			}
			createdSQL.append(SQL_TAG_ID);
			for(Tag tag: tagList) {
				createdSQL.append(String.valueOf(tag.getTagId()));
				createdSQL.append(COMMA);
			}
			createdSQL.append(SQL_TAG_ID_END_PART);
		}
		createdSQL.append(SQL_FIND_NEWS_BY_SEARCH_CRITERIA_PART_2);
		createdSQL.append(SQL_PART_3);
		createdSQL.append(String.valueOf(beginIndex+countNews-1));
		createdSQL.append(SQL_PART_4);
		createdSQL.append(String.valueOf(beginIndex));
	}
}
