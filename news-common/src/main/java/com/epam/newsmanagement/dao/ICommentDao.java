package com.epam.newsmanagement.dao;

import java.util.List;

import com.epam.newsmanagement.entity.Comment;
import com.epam.newsmanagement.exception.DaoException;

/**
 * The Interface ICommentDao.
 *
 * @author Dzmitry Hrushetski
 */
public interface ICommentDao {
	
	/**
	 * Count comments in news.
	 *
	 * @param newsId the news id
	 * @return the int
	 * @throws DaoException the dao exception
	 */
	int countCommentsInNews(Long newsId) throws DaoException;
	
	/**
	 * Find comments by news id.
	 *
	 * @param newsId the news id
	 * @return the list
	 * @throws DaoException the dao exception
	 */
	List<Comment> findCommentsByNewsId(Long newsId) throws DaoException;
	
	/**
	 * Adds the comment.
	 *
	 * @param comment the comment
	 * @throws DaoException the dao exception
	 */
	void addComment(Comment comment) throws DaoException;
	
	/**
	 * Delete comment.
	 *
	 * @param commentId the comment id
	 * @throws DaoException the dao exception
	 */
	void deleteComment(Long commentId) throws DaoException;
}
