package com.epam.newsmanagement.dao;

import java.util.List;

import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.entity.SerarchCriteria;
import com.epam.newsmanagement.exception.DaoException;

/**
 * The Interface InewsDao.
 *
 * @author Dzmitry Hrushetski
 */
public interface InewsDao {
	
	/**
	 * Find news by search criteria.
	 *
	 * @param searcCriteria the searc criteria
	 * @param beginIndex the begin index
	 * @param countNews the count news
	 * @return the list
	 * @throws DaoException the dao exception
	 */
	public List<News> findNewsBySearchCriteria(SerarchCriteria searcCriteria, int beginIndex, int countNews) throws DaoException;
	
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
