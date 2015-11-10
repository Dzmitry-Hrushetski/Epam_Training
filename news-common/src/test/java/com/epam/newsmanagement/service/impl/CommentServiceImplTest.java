package com.epam.newsmanagement.service.impl;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.epam.newsmanagement.dao.ICommentDao;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;
import com.epam.newsmanagement.service.ICommentService;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceImplTest {
	//private static final long TEST_COMMENT_ID = 3;
	@Mock private ICommentDao commentDao;
    @InjectMocks private ICommentService commentService;
    
    @Test
	public void countCommentsInNewsTest() throws ServiceException, DaoException {
    	//Comment comment = any(Comment.class);
    	Long newsId = any(Long.class);
    	commentService.countCommentsInNews(newsId);
		
		verify(commentDao).countCommentsInNews(newsId);
	}
	
	@Test(expected=ServiceException.class)
	public void countCommentsInNewsExceptionTest() throws ServiceException, DaoException {
		doThrow(DaoException.class).when(commentDao).countCommentsInNews(any(Long.class));
				
		commentService.countCommentsInNews(any(Long.class));
	}

}
