package com.epam.newsmanagement.dao.impl;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.epam.newsmanagement.dao.ICommentDao;
import com.epam.newsmanagement.entity.Comment;
import com.epam.newsmanagement.exception.DaoException;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:springConfigurationTest.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@Transactional
public class CommentDaoImplTest {
	private static final String SQL_COMMENTS_COUNT_IN_NEWS_QUERY = "SELECT COUNT(COMMENTS.NEWS_ID) FROM COMMENTS WHERE COMMENTS.NEWS_ID = ?";
	private static final String SQL_FIND_COMMENTS_BY_NEWS_ID = "SELECT COMMENTS.COMMENT_ID, COMMENTS.NEWS_ID, COMMENTS.COMMENT_TEXT, COMMENTS.CREATION_DATE FROM COMMENTS WHERE NEWS_ID = ?";
	private static final String TEST_COMMENT_TEXT = "test comment text";
	private static final String CREATION_DATE = "2015-10-25 15:45:00";
	private static final long TEST_ID = 2;
	private static final long TEST_DELETE_ID = 3;
	private static final int ONE_LINE = 1;
	
	@Autowired
	private ICommentDao commentDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Comment testComment;
	
	private RowMapper<Comment> rowMapper = new RowMapper<Comment>() {
		private static final String COMMENT_ID = "COMMENT_ID";
		private static final String NEWS_ID = "NEWS_ID";
		private static final String COMMENT_TEXT = "COMMENT_TEXT";
		private static final String CREATION_DATE = "CREATION_DATE";
		
		@Override
		public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Comment comment = new Comment();
			comment.setCommentId(rs.getLong(COMMENT_ID));
			comment.setNewsId(rs.getLong(NEWS_ID));
			comment.setCommentText(rs.getString(COMMENT_TEXT));
			comment.setCreationTimestamp(rs.getTimestamp(CREATION_DATE));
			return comment;
		}
	};
	
	@Before
	public void createTestComment() {
		testComment = new Comment();
		testComment.setCommentId(TEST_ID);
		testComment.setNewsId(TEST_ID);
		testComment.setCommentText(TEST_COMMENT_TEXT);
		testComment.setCreationTimestamp(Timestamp.valueOf(CREATION_DATE));
	}
	
	@Test
	@DatabaseSetup(value = "/test-data/comment/comment.xml", type = DatabaseOperation.INSERT)
	public void countCommentsInNewsTest() throws DaoException {

		int rowCountExpected = jdbcTemplate.queryForObject(SQL_COMMENTS_COUNT_IN_NEWS_QUERY, Integer.class, 2l);
		int rowCountReal = commentDao.countCommentsInNews(2l);

		assertEquals(rowCountExpected, rowCountReal);
	}

	@Test
	@DatabaseSetup(value = "/test-data/comment/comment.xml", type = DatabaseOperation.INSERT)
	public void findCommentsByNewsIdTest() throws DaoException {
		
		List<Comment> commentListExpected = jdbcTemplate.query(SQL_FIND_COMMENTS_BY_NEWS_ID, new Object[] { TEST_ID }, rowMapper);

		List<Comment> commentListReal = commentDao.findCommentsByNewsId(TEST_ID);

		assertEquals(commentListExpected, commentListReal);
	}
	
	@Test
	public void addCommentTest() throws DaoException {

		int rowCountBefore = jdbcTemplate.queryForObject(SQL_COMMENTS_COUNT_IN_NEWS_QUERY, Integer.class, TEST_ID);
		commentDao.addComment(testComment);
		int rowCountAfter = jdbcTemplate.queryForObject(SQL_COMMENTS_COUNT_IN_NEWS_QUERY, Integer.class, TEST_ID);

		assertEquals(rowCountBefore + ONE_LINE, rowCountAfter);
	}
	
	@Test
	@DatabaseSetup(value = "/test-data/comment/comment.xml", type = DatabaseOperation.INSERT)
	public void deleteCommentTest() throws DaoException {

		int rowCountBefore = jdbcTemplate.queryForObject(SQL_COMMENTS_COUNT_IN_NEWS_QUERY, Integer.class, TEST_ID);
		commentDao.deleteComment(TEST_DELETE_ID);
		int rowCountAfter = jdbcTemplate.queryForObject(SQL_COMMENTS_COUNT_IN_NEWS_QUERY, Integer.class, TEST_ID);

		assertEquals(rowCountBefore - ONE_LINE, rowCountAfter);
	}
}
