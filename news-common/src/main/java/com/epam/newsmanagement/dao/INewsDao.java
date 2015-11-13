package com.epam.newsmanagement.dao;

import java.util.List;

import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.entity.SearchCriteria;
import com.epam.newsmanagement.exception.DaoException;

/**
 * The Interface INewsDao.
 *
 * @author Dzmitry Hrushetski
 */
public interface INewsDao {
	
	/**
	 * Find news by search criteria.
	 *
	 * @param searchCriteria the searc criteria
	 * @param beginIndex the begin index
	 * @param countNews the count news
	 * @return the list
	 * @throws DaoException the dao exception
	 */
	public List<News> findNewsBySearchCriteria(SearchCriteria searchCriteria, int beginIndex, int countNews) throws DaoException;
	
	/**
	 * Adds the news.
	 *
	 * @param news the news
	 * @throws DaoException the dao exception
	 */
	public void addNews(News news) throws DaoException;
	
	/**
	 * Delete news.
	 *
	 * @param newsId the news id
	 * @throws DaoException the dao exception
	 */
	public void deleteNews(Long newsId) throws DaoException;
}
