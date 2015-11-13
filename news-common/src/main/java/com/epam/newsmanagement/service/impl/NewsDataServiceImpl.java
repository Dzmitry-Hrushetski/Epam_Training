package com.epam.newsmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.entity.NewsData;
import com.epam.newsmanagement.entity.Pagination;
import com.epam.newsmanagement.entity.SearchCriteria;
import com.epam.newsmanagement.exception.ServiceException;
import com.epam.newsmanagement.service.IAuthorService;
import com.epam.newsmanagement.service.ICommentService;
import com.epam.newsmanagement.service.INewsDataService;
import com.epam.newsmanagement.service.INewsService;
import com.epam.newsmanagement.service.ITagService;

public class NewsDataServiceImpl implements INewsDataService {
	
	private INewsService newsService;
	private IAuthorService authorService;
	private ITagService tagService;
	private ICommentService commentService;
	

	public ICommentService getCommentService() {
		return commentService;
	}


	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}


	public ITagService getTagService() {
		return tagService;
	}


	public void setTagService(ITagService tagService) {
		this.tagService = tagService;
	}


	public IAuthorService getAuthorService() {
		return authorService;
	}


	public void setAuthorService(IAuthorService authorService) {
		this.authorService = authorService;
	}


	public INewsService getNewsService() {
		return newsService;
	}


	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}


	@Override
	public List<NewsData> findNewsBySearchCriteria(SearchCriteria searchCriteria, Pagination pagination) throws ServiceException {
		List<NewsData> newsDataList = new ArrayList<NewsData>();
		List<News> newsList = null;
		NewsData newsData = null;
		Long newsId = null;
		
		newsList = newsService.findNewsBySearchCriteria(searchCriteria, pagination);
		
		for(News news: newsList) {
			newsId = news.getNewsId();
			newsData = new NewsData();
			newsData.setNews(news);
			newsData.setAutor(authorService.findAuthorByNewsId(newsId));
			newsData.setTags(tagService.findAllTagsByNewsID(newsId));
			newsData.setComments(commentService.findCommentsByNewsId(newsId));
			newsDataList.add(newsData);
		}
		return newsDataList;
	}
}
