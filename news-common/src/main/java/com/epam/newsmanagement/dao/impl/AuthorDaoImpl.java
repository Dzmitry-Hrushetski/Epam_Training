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

import com.epam.newsmanagement.dao.IAuthorDao;
import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.exception.DaoException;

/**
 * The Class AuthorDaoImpl.
 *
 * @author Dzmitry Hrushetski
 */
public class AuthorDaoImpl implements IAuthorDao {
	private static final String SQL_FIND_ALL_AUTHORS = "SELECT AUTHOR.AUTHOR_ID, AUTHOR.AUTHOR_NAME, AUTHOR.EXPIRED FROM AUTHOR";
	private static final String SQL_FIND_AUTHOR_BY_NEWS_ID = "SELECT AUTHOR.AUTHOR_ID, AUTHOR.AUTHOR_NAME, AUTHOR.EXPIRED FROM AUTHOR INNER JOIN NEWS_AUTHOR ON NEWS_AUTHOR.AUTHOR_ID = AUTHOR.AUTHOR_ID WHERE NEWS_AUTHOR.NEWS_ID = ?";
	private static final String SQL_UPDATE_AUTHOR = "UPDATE AUTHOR SET AUTHOR.AUTHOR_NAME = ?, AUTHOR.EXPIRED = ? WHERE AUTHOR.AUTHOR_ID = ?";
	private static final String SQL_ADD_NEW_AUTHOR = "INSERT INTO AUTHOR (AUTHOR.AUTHOR_NAME, AUTHOR.EXPIRED) VALUES (?, ?)";
	private static final String SQL_LINK_AUTHOR_WIHT_NEWS = "INSERT INTO NEWS_AUTHOR (NEWS_AUTHOR.NEWS_ID, NEWS_AUTHOR.AUTHOR_ID) VALUES (?, ?)";
	private static final String SQL_EXPIRE_AUTHOR = "UPDATE AUTHOR SET AUTHOR.EXPIRED = ? WHERE AUTHOR.AUTHOR_ID = ?";
	
	private static final String AUTHOR_ID = "AUTHOR_ID";
	private static final String AUTHOR_NAME = "AUTHOR_NAME";
	private static final String EXPIRED = "EXPIRED";
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
	 * @see com.epam.newsmanagement.dao.IAuthorDao#findAllAuthors()
	 */
	@Override
	public List<Author> findAllAuthors() throws DaoException {
		ArrayList<Author> authorsList = new ArrayList<Author>();
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		Author author=null;
		
		try {
			connection = doGetConnection(dataSource);
			st = connection.createStatement();
			rs = st.executeQuery(SQL_FIND_ALL_AUTHORS);
			
			while (rs.next()) {
				author = new Author();
				author.setAuthorId(rs.getLong(AUTHOR_ID));
				author.setAuthorName(rs.getString(AUTHOR_NAME));
				author.setExpiredTimestamp(rs.getTimestamp(EXPIRED));
				authorsList.add(author);
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error, AuthorDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(st);
			releaseConnection(connection, dataSource);
		}
		return authorsList;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.IAuthorDao#findAuthorByNewsId(java.lang.Long)
	 */
	@Override
	public Author findAuthorByNewsId(Long newsId) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Author author=null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_FIND_AUTHOR_BY_NEWS_ID);
			ps.setLong(1,newsId);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				author = new Author();
				author.setAuthorId(rs.getLong(AUTHOR_ID));
				author.setAuthorName(rs.getString(AUTHOR_NAME));
				author.setExpiredTimestamp(rs.getTimestamp(EXPIRED));
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error, AuthorDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
		return author;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.IAuthorDao#updateAuthor(com.epam.newsmanagement.entity.Author)
	 */
	@Override
	public void updateAuthor(Author author) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_UPDATE_AUTHOR);
			ps.setString(1, author.getAuthorName());
			ps.setTimestamp(2, author.getExpiredTimestamp());
			ps.setLong(3,author.getAuthorId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException("Database error, AuthorDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.IAuthorDao#addAuthor(com.epam.newsmanagement.entity.Author)
	 */
	@Override
	public void addAuthor(Author author) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_ADD_NEW_AUTHOR, new String [] {AUTHOR_ID});
			ps.setString(1, author.getAuthorName());
			ps.setTimestamp(2, author.getExpiredTimestamp()); 
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			while (rs.next()) {
				author.setAuthorId(rs.getLong(FIRST_COLUMN));
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error, AuthorDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.IAuthorDao#linkAuthorWithNews(java.lang.Long, java.lang.Long)
	 */
	@Override
	public void linkAuthorWithNews(Long newsId, Long authorId) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_LINK_AUTHOR_WIHT_NEWS);
			ps.setLong(1,newsId);
			ps.setLong(2,authorId);
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException("Database error, AuthorDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
	}

	@Override
	public void expireAuthor(Author author) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_EXPIRE_AUTHOR);
			ps.setTimestamp(1, author.getExpiredTimestamp());
			ps.setLong(2,author.getAuthorId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException("Database error, AuthorDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
	}
}
