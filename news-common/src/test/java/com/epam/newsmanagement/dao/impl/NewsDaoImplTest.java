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

import com.epam.newsmanagement.dao.INewsDao;
import com.epam.newsmanagement.entity.News;
import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:springConfigurationTest.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@Transactional
public class NewsDaoImplTest {
	
	@Autowired
	private INewsDao newsDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private News testNews;
	
	private RowMapper<News> rowMapper = new RowMapper<News>() {
		private static final String NEWS_ID = "NEWS_ID";
		private static final String TITLE = "TITLE";
		private static final String SHORT_TEXT = "SHORT_TEXT";
		private static final String FULL_TEXT = "FULL_TEXT";
		private static final String CREATION_DATE = "CREATION_DATE";
		private static final String MODIFICATION_DATE = "MODIFICATION_DATE";
		
		@Override
		public News mapRow(ResultSet rs, int rowNum) throws SQLException {
			News news = new News();
			news = new News();
			news.setNewsId(rs.getLong(NEWS_ID));
			news.setTitle(rs.getString(TITLE));
			news.setShortText(rs.getString(SHORT_TEXT));
			news.setFullText(rs.getString(FULL_TEXT));
			news.setCreationTimestamp(rs.getTimestamp(CREATION_DATE));
			news.setModificationDate(rs.getDate(MODIFICATION_DATE));
			return news;
		}
	};

}
