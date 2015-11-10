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

import com.epam.newsmanagement.dao.ITagDao;
import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.DaoException;

/**
 * The Class TagDaoImpl.
 *
 * @author Dzmitry Hrushetski
 */
public class TagDaoImpl implements ITagDao {
	private static final String SQL_UPDATE_TAG = "UPDATE TAG SET TAG.TAG_NAME = ? WHERE TAG.TAG_ID = ?";
	private static final String SQL_ADD_NEW_TAG = "INSERT INTO TAG (TAG.TAG_NAME) VALUES (?)";
	private static final String SQL_FIND_TAG_BY_ID = "SELECT TAG.TAG_NAME, TAG.TAG_ID FROM TAG WHERE TAG.TAG_ID = ?";
	private static final String SQL_FIND_ALL_TAGS = "SELECT TAG.TAG_NAME, TAG.TAG_ID FROM TAG";
	private static final String SQL_FIND_TAG_BY_NEWS_ID = "SELECT TAG.TAG_NAME, TAG.TAG_ID FROM TAG INNER JOIN NEWS_TAG ON NEWS_TAG.TAG_ID = TAG.TAG_ID WHERE NEWS_TAG.NEWS_ID = ?";
	private static final String SQL_DELETE_TAG = "DELETE FROM TAG WHERE TAG.TAG_ID = ?";
	private static final String SQL_LINK_TAG_WIHT_NEWS = "INSERT INTO NEWS_TAG (NEWS_TAG.NEWS_ID, NEWS_TAG.TAG_ID) VALUES (?, ?)";
	private static final String SQL_DETACH_TAG_FROM_NEWS = "DELETE FROM NEWS_TAG WHERE NEWS_TAG.NEWS_ID = ? AND NEWS_TAG.TAG_ID = ?";
	private static final String SQL_DETACH_ALL_TAGS_FROM_NEWS = "DELETE FROM NEWS_TAG WHERE NEWS_TAG.NEWS_ID = ?";
	private static final String TAG_NAME = "TAG_NAME";
	private static final String TAG_ID = "TAG_ID";
	//private static final String NEWS_ID = "NEWS_TAG.TAG_ID";
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
	 * @see com.epam.newsmanagement.dao.ITagDao#findTagByID(java.lang.Long)
	 */
	@Override
	public Tag findTagByID(Long tagId) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Tag tag=null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_FIND_TAG_BY_ID);
			ps.setLong(1,tagId);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				tag = new Tag();
				tag.setTagId(rs.getLong(TAG_ID));
				tag.setTagName(rs.getString(TAG_NAME));
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error, TagDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
		return tag;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.ITagDao#findAllTags()
	 */
	@Override
	public List<Tag> findAllTags() throws DaoException {
		ArrayList<Tag> tagsList = new ArrayList<Tag>();
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		Tag tag=null;
		
		try {
			connection = doGetConnection(dataSource);
			st = connection.createStatement();
			rs = st.executeQuery(SQL_FIND_ALL_TAGS);
			
			while (rs.next()) {
				tag = new Tag();
				tag.setTagId(rs.getLong(TAG_ID));
				tag.setTagName(rs.getString(TAG_NAME));
				tagsList.add(tag);
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error, TagDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(st);
			releaseConnection(connection, dataSource);
		}
		return tagsList;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.ITagDao#findAllTagsByNewsID(java.lang.Long)
	 */
	@Override
	public List<Tag> findAllTagsByNewsID(Long newsId) throws DaoException {
		ArrayList<Tag> tagsList = new ArrayList<Tag>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Tag tag=null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_FIND_TAG_BY_NEWS_ID);
			ps.setLong(1,newsId);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				tag = new Tag();
				tag.setTagId(rs.getLong(TAG_ID));
				tag.setTagName(rs.getString(TAG_NAME));
				tagsList.add(tag);
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error, TagDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
		return tagsList;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.ITagDao#addNewTag(com.epam.newsmanagement.entity.Tag)
	 */
	@Override
	public void addNewTag(Tag tag) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			//connection = dataSource.getConnection();
			ps = connection.prepareStatement(SQL_ADD_NEW_TAG, new String [] {TAG_ID});
			ps.setString(1, tag.getTagName()); 
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			while (rs.next()) {
				tag.setTagId(rs.getLong(FIRST_COLUMN));
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error, TagDaoImpl.", ex);
		} finally {
			//DbUtils.closeQuietly(connection, ps, rs);
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.ITagDao#updateTag(com.epam.newsmanagement.entity.Tag)
	 */
	@Override
	public void updateTag(Tag tag) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_UPDATE_TAG);
			ps.setString(1, tag.getTagName());
			ps.setLong(2,tag.getTagId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException("Database error, TagDao.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.ITagDao#deleteTag(java.lang.Long)
	 */
	@Override
	public void deleteTag(Long tagId) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_DELETE_TAG);
			ps.setLong(1,tagId);
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException("Database error, TagDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.ITagDao#linkTagWithNews(java.lang.Long, java.lang.Long)
	 */
	@Override
	public void linkTagWithNews(Long newsId, Long tagId) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_LINK_TAG_WIHT_NEWS);
			ps.setLong(1, newsId);
			ps.setLong(2, tagId);
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException("Database error, TagDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.ITagDao#detachTagFromNews(java.lang.Long, java.lang.Long)
	 */
	@Override
	public void detachTagFromNews(Long newsId, Long tagId) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_DETACH_TAG_FROM_NEWS);
			ps.setLong(1,newsId);
			ps.setLong(2,tagId);
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException("Database error, TagDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.dao.ITagDao#detachAllTagsFromNews(java.lang.Long)
	 */
	@Override
	public void detachAllTagsFromNews(Long newsId) throws DaoException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = doGetConnection(dataSource);
			ps = connection.prepareStatement(SQL_DETACH_ALL_TAGS_FROM_NEWS);
			ps.setLong(1,newsId);
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException("Database error, TagDaoImpl.", ex);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			releaseConnection(connection, dataSource);
		}
	}
}
