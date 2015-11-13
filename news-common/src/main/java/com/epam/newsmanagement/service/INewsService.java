package com.epam.newsmanagement.service;

import java.util.List;

import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.entity.Pagination;
import com.epam.newsmanagement.entity.SearchCriteria;
import com.epam.newsmanagement.exception.ServiceException;

/**
 * The Interface INewsService.
 *
 * @author Dzmitry Hrushetski
 */
public interface INewsService {
	
	/**
	 * Find news by search criteria.
	 *
	 * @param searchCriteria the search criteria
	 * @param pagination the pagination
	 * @return the list
	 * @throws ServiceException the service exception
	 */
	List<News> findNewsBySearchCriteria( SearchCriteria searchCriteria, Pagination pagination) throws ServiceException;
	
	/**
	 * Delete news.
	 *
	 * @param newsId the news id
	 * @throws ServiceException the service exception
	 */
	void deleteNews(Long newsId) throws ServiceException;
	
	/**
	 * Adds the news.
	 *
	 * @param news the news
	 * @throws ServiceException the service exception
	 */
	void addNews(News news) throws ServiceException;
}
