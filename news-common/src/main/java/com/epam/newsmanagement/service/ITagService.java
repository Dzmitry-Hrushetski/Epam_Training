package com.epam.newsmanagement.service;

import java.util.List;

import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.ServiceException;



/**
 * The Interface ITagService.
 *
 * @author Dzmitry Hrushetski
 */
public interface ITagService {
	
	/**
	 * Find all tags.
	 *
	 * @return the list
	 * @throws ServiceException the service exception
	 */
	public List<Tag> findAllTags() throws ServiceException;
	
	/**
	 * Find all tags by news id.
	 *
	 * @param newsId the news id
	 * @return the list
	 * @throws ServiceException the service exception
	 */
	public List<Tag> findAllTagsByNewsID(Long newsId) throws ServiceException;
		
	/**
	 * Adds the new tag.
	 *
	 * @param tag the tag
	 * @throws ServiceException the service exception
	 */
	public void addNewTag(Tag tag) throws ServiceException;
	
	/**
	 * Update tag.
	 *
	 * @param tag the tag
	 * @throws ServiceException the service exception
	 */
	public void updateTag(Tag tag) throws ServiceException;
	
	/**
	 * Delete tag.
	 *
	 * @param tagId the tag id
	 * @throws ServiceException the service exception
	 */
	public void deleteTag(Long tagId) throws ServiceException;
	
	/**
	 * Update tag list by news.
	 *
	 * @param newsId the news id
	 * @param tagList the tag list
	 * @throws ServiceException the service exception
	 */
	public void updateTagListByNews(Long newsId, List<Tag> tagList) throws ServiceException;
}
