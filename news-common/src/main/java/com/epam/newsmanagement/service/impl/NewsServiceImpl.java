package com.epam.newsmanagement.service.impl;

import java.util.List;

import com.epam.newsmanagement.dao.INewsDao;
import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.entity.Pagination;
import com.epam.newsmanagement.entity.SearchCriteria;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;
import com.epam.newsmanagement.service.INewsService;

public class NewsServiceImpl implements INewsService {
	
	private INewsDao newsDao;

	public INewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(INewsDao newsDao) {
		this.newsDao = newsDao;
	}

	@Override
	public List<News> findNewsBySearchCriteria(SearchCriteria searchCriteria, Pagination pagination) throws ServiceException {
		List<News> newsList = null;
		try {
			newsList = newsDao.findNewsBySearchCriteria(searchCriteria, 1, 3);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
		return newsList;
	}

	@Override
	public void deleteNews(Long newsId) throws ServiceException {
		try {
			newsDao.deleteNews(newsId);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
	}

	@Override
	public void addNews(News news) throws ServiceException {
		try {
			newsDao.addNews(news);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
	}
}
