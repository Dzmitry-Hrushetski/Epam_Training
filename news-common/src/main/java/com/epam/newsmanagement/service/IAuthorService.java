package com.epam.newsmanagement.service;

import java.util.List;

import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.exception.ServiceException;

/**
 * The Interface IAuthorService.
 *
 * @author Dzmitry Hrushetski
 */
public interface IAuthorService {
	
	/**
	 * Find all authors.
	 *
	 * @return the list
	 * @throws ServiceException the service exception
	 */
	public List<Author> findAllAuthors() throws ServiceException;
	
	/**
	 * Find author by news id.
	 *
	 * @param newsId the news id
	 * @return the author
	 * @throws ServiceException the service exception
	 */
	public Author findAuthorByNewsId(Long newsId) throws ServiceException;
	
	/**
	 * Update author.
	 *
	 * @param author the author
	 * @throws ServiceException the service exception
	 */
	public void updateAuthor(Author author) throws ServiceException;
	
	/**
	 * Adds the author.
	 *
	 * @param author the author
	 * @throws ServiceException the service exception
	 */
	public void addAuthor(Author author) throws ServiceException;
	
	/**
	 * Link author with news.
	 *
	 * @param newsId the news id
	 * @param authorId the author id
	 * @throws ServiceException the service exception
	 */
	public void linkAuthorWithNews(Long newsId, Long authorId) throws ServiceException;
	
	/**
	 * Expire author.
	 *
	 * @param author the author
	 * @throws ServiceException the service exception
	 */
	public void expireAuthor(Author author) throws ServiceException;
}
