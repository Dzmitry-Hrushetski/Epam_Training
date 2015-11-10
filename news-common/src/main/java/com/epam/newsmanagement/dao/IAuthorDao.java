package com.epam.newsmanagement.dao;

import java.util.List;

import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.exception.DaoException;

/**
 * The Interface IAuthorDao.
 *
 * @author Dzmitry Hrushetski
 */
public interface IAuthorDao {
	
	/**
	 * Find all authors.
	 *
	 * @return the list
	 * @throws DaoException the dao exception
	 */
	public List<Author> findAllAuthors() throws DaoException;
	
	/**
	 * Find author by news id.
	 *
	 * @param newsId the news id
	 * @return the author
	 * @throws DaoException the dao exception
	 */
	public Author findAuthorByNewsId(Long newsId) throws DaoException;
	
	/**
	 * Update author.
	 *
	 * @param author the author
	 * @throws DaoException the dao exception
	 */
	public void updateAuthor(Author author) throws DaoException;
	
	/**
	 * Adds the author.
	 *
	 * @param author the author
	 * @throws DaoException the dao exception
	 */
	public void addAuthor(Author author) throws DaoException;
	
	/**
	 * Link author with news.
	 *
	 * @param newsId the news id
	 * @param authorId the author id
	 * @throws DaoException the dao exception
	 */
	public void linkAuthorWithNews(Long newsId, Long authorId) throws DaoException;
	
	/**
	 * Expire author.
	 *
	 * @param author the author
	 * @throws DaoException the dao exception
	 */
	public void expireAuthor(Author author) throws DaoException;
}
