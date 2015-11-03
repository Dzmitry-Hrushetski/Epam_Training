package com.epam.newsmanagement.dao.impl;

import static org.apache.commons.dbutils.DbUtils.closeQuietly;
import static org.springframework.jdbc.datasource.DataSourceUtils.doGetConnection;
import static org.springframework.jdbc.datasource.DataSourceUtils.releaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.epam.newsmanagement.dao.ICommentDao;
import com.epam.newsmanagement.entity.Comment;
import com.epam.newsmanagement.exception.DaoException;

public class CommentDaoImpl implements ICommentDao {
	private static final String SQL_COMMENTS_COUNT_IN_NEWS_QUERY = "SELECT COUNT(COMMENTS.NEWS_ID) FROM COMMENTS WHERE COMMENTS.NEWS_ID = ?";
	private static final String SQL_FIND_COMMENTS_BY_NEWS_ID = "SELECT COMMENTS.COMMENT_ID, COMMENTS.NEWS_ID, COMMENTS.COMMENT_TEXT, COMMENTS.CREATION_DATE FROM COMMENTS WHERE NEWS_ID = ?";
	private static final String SQL_ADD_NEW_COMMENT = "INSERT INTO COMMENTS (COMMENTS.NEWS_ID, COMMENTS.COMMENT_TEXT, COMMENTS.CREATION_DATE) VALUES (?, ?, ?)";
	private static final String SQL_DELETE_COMMENT = "DELETE FROM COMMENTS WHERE COMMENTS.COMMENT_ID = ?";
	private static final String COMMENT_ID = "COMMENT_ID";
	private static final String NEWS_ID = "NEWS_ID";
	private static final String COMMENT_TEXT = "COMMENT_TEXT";
	private static final String CREATON_DATE = "CREATION_DATE";
	private static final int FIRST_COLUMN = 1;
	
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int countCommentsInNews(Long newsId) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int commentsCount = 0;
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_COMMENTS_COUNT_IN_NEWS_QUERY);
			ps.setLong(1,newsId);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				commentsCount = rs.getInt(FIRST_COLUMN);
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error, CommentDaoImpl.", ex);
		} finally {
			releaseConnection(connection, dataSource);
			closeQuietly(ps);
			closeQuietly(rs);
		}
		return commentsCount;
	}

	@Override
	public List<Comment> findCommentsByNewsId(Long newsId) throws DaoException {
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		Comment comment = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_FIND_COMMENTS_BY_NEWS_ID);
			ps.setLong(1,newsId);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				comment = new Comment();
				comment.setCommentId(rs.getLong(COMMENT_ID));
				comment.setNewsId(rs.getLong(NEWS_ID));
				comment.setCommentText(rs.getString(COMMENT_TEXT));
				comment.setCreationTimestamp(rs.getTimestamp(CREATON_DATE));
				commentList.add(comment);
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error, CommentDaoImpl.", ex);
		} finally {
			releaseConnection(connection, dataSource);
			closeQuietly(ps);
			closeQuietly(rs);
		}
		return commentList;
	}

	@Override
	public void addComment(Comment comment) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_ADD_NEW_COMMENT, new String [] {COMMENT_ID});
			ps.setLong(1, comment.getNewsId());
			ps.setString(2, comment.getCommentText()); 
			ps.setTimestamp(3, comment.getCreationTimestamp());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			while (rs.next()) {
				comment.setCommentId(rs.getLong(FIRST_COLUMN));
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error, CommentDaoImpl.", ex);
		} finally {
			releaseConnection(connection, dataSource);
			closeQuietly(ps);
			closeQuietly(rs);
		}
	}

	@Override
	public void deleteComment(Long commentId) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_DELETE_COMMENT);
			ps.setLong(1, commentId);
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException("Database error, CommentDaoImpl.", ex);
		} finally {
			releaseConnection(connection, dataSource);
			closeQuietly(ps);
			closeQuietly(rs);
		}
	}
}
