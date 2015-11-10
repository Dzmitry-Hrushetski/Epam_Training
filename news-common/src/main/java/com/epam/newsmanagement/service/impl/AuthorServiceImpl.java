package com.epam.newsmanagement.service.impl;

import java.util.List;

import com.epam.newsmanagement.dao.IAuthorDao;
import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;
import com.epam.newsmanagement.service.IAuthorService;

/**
 * The Class AuthorServiceImpl.
 *
 * @author Dzmitry Hrushetski
 */
public class AuthorServiceImpl implements IAuthorService {
	
	private IAuthorDao authorDao;

	/**
	 * Gets the author dao.
	 *
	 * @return the author dao
	 */
	public IAuthorDao getAuthorDao() {
		return authorDao;
	}

	/**
	 * Sets the author dao.
	 *
	 * @param authorDao the new author dao
	 */
	public void setAuthorDao(IAuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.service.IAuthorService#findAllAuthors()
	 */
	@Override
	public List<Author> findAllAuthors() throws ServiceException {
		List<Author> authorsList = null;
		try {
			authorsList = authorDao.findAllAuthors();
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
		return authorsList;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.service.IAuthorService#findAuthorByNewsId(java.lang.Long)
	 */
	@Override
	public Author findAuthorByNewsId(Long newsId) throws ServiceException {
		Author author = null;
		try {
			author = authorDao.findAuthorByNewsId(newsId);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
		return author;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.service.IAuthorService#updateAuthor(com.epam.newsmanagement.entity.Author)
	 */
	@Override
	public void updateAuthor(Author author) throws ServiceException {
		try {
			authorDao.updateAuthor(author);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.service.IAuthorService#addAuthor(com.epam.newsmanagement.entity.Author)
	 */
	@Override
	public void addAuthor(Author author) throws ServiceException {
		try {
			authorDao.addAuthor(author);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.service.IAuthorService#linkAuthorWithNews(java.lang.Long, java.lang.Long)
	 */
	@Override
	public void linkAuthorWithNews(Long newsId, Long authorId) throws ServiceException {
		try {
			authorDao.linkAuthorWithNews(newsId, authorId);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.service.IAuthorService#expireAuthor(java.lang.Long)
	 */
	@Override
	public void expireAuthor(Author author) throws ServiceException {
		try {
			authorDao.expireAuthor(author);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
	}
}
