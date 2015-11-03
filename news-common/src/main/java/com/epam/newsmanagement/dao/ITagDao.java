package com.epam.newsmanagement.dao;

import java.util.List;

import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.DaoException;

/**
 * The Interface ITagDao.
 *
 * @author Dzmitry Hrushetski
 */
public interface ITagDao  {
	
	/**
	 * Find tag by id.
	 *
	 * @param tagId the tag id
	 * @return the tag
	 * @throws DaoException the dao exception
	 */
	public Tag findTagByID(Long tagId) throws DaoException;

	/**
	 * Find all tags.
	 *
	 * @return the list
	 * @throws DaoException the dao exception
	 */
	public List<Tag> findAllTags() throws DaoException;
	
	/**
	 * Find all tags by news id.
	 *
	 * @param newsId the news id
	 * @return the list
	 * @throws DaoException the dao exception
	 */
	public List<Tag> findAllTagsByNewsID(Long newsId) throws DaoException;
	
	/**
	 * Adds the new tag.
	 *
	 * @param tag the tag
	 * @throws DaoException the dao exception
	 */
	public void addNewTag(Tag tag) throws DaoException;
	
	/**
	 * Update tag.
	 *
	 * @param tag the tag
	 * @throws DaoException the dao exception
	 */
	public void updateTag(Tag tag) throws DaoException;
	
	/**
	 * Delete tag.
	 *
	 * @param tagId the tag id
	 * @throws DaoException the dao exception
	 */
	public void deleteTag(Long tagId) throws DaoException;
	
	/**
	 * Link tag with news.
	 *
	 * @param newsId the news id
	 * @param tagId the tag id
	 * @throws DaoException the dao exception
	 */
	public void linkTagWithNews(Long newsId, Long tagId) throws DaoException;
	
	/**
	 * Detach tag from news.
	 *
	 * @param newsId the news id
	 * @param tagId the tag id
	 * @throws DaoException the dao exception
	 */
	public void detachTagFromNews(Long newsId, Long tagId) throws DaoException;
	
	/**
	 * Detach all tags from news.
	 *
	 * @param newsId the news id
	 * @throws DaoException the dao exception
	 */
	public void detachAllTagsFromNews(Long newsId) throws DaoException;
}
