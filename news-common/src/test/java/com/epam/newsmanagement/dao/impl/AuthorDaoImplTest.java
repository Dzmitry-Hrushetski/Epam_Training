package com.epam.newsmanagement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

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
import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:springConfigurationTest.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@Transactional
public class AuthorDaoImplTest {
	
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

}
