package com.epam.newsmanagement.service;

import java.util.List;

import com.epam.newsmanagement.entity.Comment;
import com.epam.newsmanagement.exception.ServiceException;

/**
 * The Interface ICommentService.
 *
 * @author Dzmitry Hrushetski
 */
public interface ICommentService {
	
	/**
	 * Count comments in news.
	 *
	 * @param newsId the news id
	 * @return the int
	 * @throws ServiceException the service exception
	 */
	int countCommentsInNews(Long newsId) throws ServiceException;
		
	/**
	 * Find comments by news id.
	 *
	 * @param newsId the news id
	 * @return the list
	 * @throws ServiceException the service exception
	 */
	List<Comment> findCommentsByNewsId(Long newsId) throws ServiceException;
		
	/**
	 * Adds the comment.
	 *
	 * @param comment the comment
	 * @throws ServiceException the service exception
	 */
	void addComment(Comment comment) throws ServiceException;
		
	/**
	 * Delete comment.
	 *
	 * @param commentId the comment id
	 * @throws ServiceException the service exception
	 */
	void deleteComment(Long commentId) throws ServiceException;
}
