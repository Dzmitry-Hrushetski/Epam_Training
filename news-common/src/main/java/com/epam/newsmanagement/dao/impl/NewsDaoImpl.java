package com.epam.newsmanagement.dao.impl;

import static org.apache.commons.dbutils.DbUtils.closeQuietly;
import static org.springframework.jdbc.datasource.DataSourceUtils.doGetConnection;
import static org.springframework.jdbc.datasource.DataSourceUtils.releaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.epam.newsmanagement.dao.InewsDao;
import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.entity.SerarchCriteria;
import com.epam.newsmanagement.exception.DaoException;

/**
 * The Class NewsDaoImpl.
 *
 * @author Dzmitry Hrushetski
 */
public class NewsDaoImpl implements InewsDao {
	private static final String SQL_ADD_NEWS = "INSERT INTO NEWS (NEWS.TITLE, NEWS.SHORT_TEXT, NEWS.FULL_TEXT, NEWS.CREATION_DATE, NEWS.MODIFICATION_DATE) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_DELETE_NEWS = "DELETE FROM NEWS WHERE NEWS.NEWS_ID = ?";
	private static final String SQL_JOIN_NEWS_NEWS_AUTHOR = "INNER JOIN NEWS_AUTHOR ON NEWS_AUTHOR.NEWS_ID = NEWS.NEWS_ID";
	private static final String SQL_JOIN_NEWS_NEWS_TAG = "INNER JOIN NEWS_TAG ON NEWS_TAG.NEWS_ID = NEWS.NEWS_ID";
	
	//SELECT * FROM NEWS INNER JOIN NEWS_TAG ON NEWS_TAG.NEWS_ID = NEWS.NEWS_ID  WHERE NEWS_TAG.TAG_ID = 124 ORDER BY NEWS.CREATION_DATE DESC;
	
	private static final String NEWS_ID = "NEWS_ID";
	
	private static final int FIRST_COLUMN = 1;
	
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
	 * @see com.epam.newsmanagement.dao.InewsDao#findNewsBySearchCriteria(com.epam.newsmanagement.entity.SerarchCriteria, int, int)
	 */
	@Override
	public List<News> findNewsBySearchCriteria(SerarchCriteria searcCriteria, int beginIndex, int countNews) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.InewsDao#addNews(com.epam.newsmanagement.entity.News)
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
	 * @see com.epam.newsmanagement.dao.InewsDao#deleteNews(java.lang.Long)
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
}
