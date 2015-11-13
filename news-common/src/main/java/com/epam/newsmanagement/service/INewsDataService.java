package com.epam.newsmanagement.service;

import java.util.List;

import com.epam.newsmanagement.entity.NewsData;
import com.epam.newsmanagement.entity.Pagination;
import com.epam.newsmanagement.entity.SearchCriteria;
import com.epam.newsmanagement.exception.ServiceException;

public interface INewsDataService {
	
	List<NewsData> findNewsBySearchCriteria( SearchCriteria searchCriteria, Pagination pagination) throws ServiceException;

}
