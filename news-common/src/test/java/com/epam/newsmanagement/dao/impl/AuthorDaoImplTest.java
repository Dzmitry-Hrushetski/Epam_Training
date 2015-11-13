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

import com.epam.newsmanagement.dao.IAuthorDao;
import com.epam.newsmanagement.entity.Author;
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
public class AuthorDaoImplTest {
	private static final String SQL_AUTHOR_COUNT_QUERY = "SELECT COUNT(AUTHOR.AUTHOR_ID) FROM AUTHOR";
	private static final String SQL_FIND_AUTHOR_BY_ID = "SELECT AUTHOR.AUTHOR_ID, AUTHOR.AUTHOR_NAME, AUTHOR.EXPIRED FROM AUTHOR WHERE AUTHOR.AUTHOR_ID = ?";
	
	private static final String TEST_AUTHOR_NAME = "author name 1";
	private static final String TEST_NEW_AUTHOR_NAME = "new author name";
	private static final String EXPIRED = "3015-01-01 00:00:00";
	private static final long TEST_ID = 11;
	private static final long TEST_NEWS_ID = 1;
	private static final int ONE_LINE = 1;
	
	
	@Autowired
	private IAuthorDao authorDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Author testAuthor;
	
	private RowMapper<Author> rowMapper = new RowMapper<Author>() {
		private static final String AUTHOR_ID = "AUTHOR_ID";
		private static final String AUTHOR_NAME = "AUTHOR_NAME";
		private static final String EXPIRED = "EXPIRED";
		
		@Override
		public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
			Author author = new Author();
			author.setAuthorId(rs.getLong(AUTHOR_ID));
			author.setAuthorName(rs.getString(AUTHOR_NAME));
			author.setExpiredTimestamp(rs.getTimestamp(EXPIRED));
			return author;
		}
	};
	
	@Before
	public void createTestAuthor() {
		testAuthor = new Author();
		testAuthor.setAuthorId(TEST_ID);
		testAuthor.setAuthorName(TEST_AUTHOR_NAME);
		testAuthor.setExpiredTimestamp(Timestamp.valueOf(EXPIRED));
	}
	
	@Test
	@DatabaseSetup(value = "/test-data/author/author.xml", type = DatabaseOperation.INSERT)
	public void findAllAuthorsTest() throws DaoException {
		int rowCount = jdbcTemplate.queryForObject(SQL_AUTHOR_COUNT_QUERY, Integer.class);
		List<Author> authorsList = authorDao.findAllAuthors();
		assertEquals(rowCount, authorsList.size());
	}

	@Test
	@DatabaseSetup(value = "/test-data/author/author.xml", type = DatabaseOperation.INSERT)
	public void findAuthorByNewsIdTest() throws DaoException {
		Author author = authorDao.findAuthorByNewsId(TEST_NEWS_ID);

		assertEquals(author, testAuthor);
	}
	
	@Test
	@DatabaseSetup(value = "/test-data/author/author.xml", type = DatabaseOperation.INSERT)
	public void updateAuthorTest() throws DaoException {
		testAuthor.setAuthorName(TEST_NEW_AUTHOR_NAME);
		authorDao.updateAuthor(testAuthor);

		Author author = jdbcTemplate.queryForObject(SQL_FIND_AUTHOR_BY_ID, rowMapper, testAuthor.getAuthorId());

		assertEquals(author, testAuthor);
	}
	
	@Test
	@DatabaseSetup(value = "/test-data/author/author.xml", type = DatabaseOperation.INSERT)
	public void addAuthorTest() throws DaoException {
		int rowCountBefore = jdbcTemplate.queryForObject(SQL_AUTHOR_COUNT_QUERY, Integer.class);

		authorDao.addAuthor(testAuthor);

		int rowCountAfter = jdbcTemplate.queryForObject(SQL_AUTHOR_COUNT_QUERY, Integer.class);

		assertEquals(rowCountBefore + ONE_LINE, rowCountAfter);
		
	}
	
	@Test
	@DatabaseSetup(value = "/test-data/author/author.xml", type = DatabaseOperation.INSERT)
	public void linkAuthorWithNewsTest() throws DaoException {
		
	}
}
