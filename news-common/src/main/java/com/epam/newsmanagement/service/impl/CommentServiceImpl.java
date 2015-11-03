package com.epam.newsmanagement.service.impl;

import java.util.List;

import com.epam.newsmanagement.dao.impl.CommentDaoImpl;
import com.epam.newsmanagement.entity.Comment;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;
import com.epam.newsmanagement.service.ICommentService;

/**
 * The Class CommentServiceImpl.
 *
 * @author Dzmitry Hrushetski
 */
public class CommentServiceImpl implements ICommentService{
	
	private CommentDaoImpl commentDao;

	/**
	 * Gets the comment dao.
	 *
	 * @return the comment dao
	 */
	public CommentDaoImpl getCommentDao() {
		return commentDao;
	}

	/**
	 * Sets the comment dao.
	 *
	 * @param commentDao the new comment dao
	 */
	public void setCommentDao(CommentDaoImpl commentDao) {
		this.commentDao = commentDao;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.service.ICommentService#countCommentsInNews(java.lang.Long)
	 */
	@Override
	public int countCommentsInNews(Long newsId) throws ServiceException {
		int commentsCount = 0;
		try {
			commentsCount = commentDao.countCommentsInNews(newsId);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
		return commentsCount;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.service.ICommentService#findCommentsByNewsId(java.lang.Long)
	 */
	@Override
	public List<Comment> findCommentsByNewsId(Long newsId) throws ServiceException {
		List<Comment> commentList = null;
		try {
			commentList = commentDao.findCommentsByNewsId(newsId);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
		return commentList;
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.service.ICommentService#addComment(com.epam.newsmanagement.entity.Comment)
	 */
	@Override
	public void addComment(Comment comment) throws ServiceException {
		try {
			commentDao.addComment(comment);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.newsmanagement.service.ICommentService#deleteComment(java.lang.Long)
	 */
	@Override
	public void deleteComment(Long commentId) throws ServiceException {
		try {
			commentDao.deleteComment(commentId);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
	}
}
