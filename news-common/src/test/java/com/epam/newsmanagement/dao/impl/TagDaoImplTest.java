package com.epam.newsmanagement.dao.impl;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
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

import com.epam.newsmanagement.dao.ITagDao;
import com.epam.newsmanagement.entity.Tag;
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
public class TagDaoImplTest {
	private static final Logger LOG = Logger.getLogger(TagDaoImplTest.class);

	private static final String SQL_TAG_COUNT_QUERY = "SELECT COUNT(TAG.TAG_ID) FROM TAG";
	private static final String SQL_FIND_TAG_BY_ID = "SELECT TAG_NAME, TAG_ID FROM TAG WHERE TAG_ID = ?";
	private static final String SQL_FIND_TAG_BY_NEWS_ID = "SELECT TAG.TAG_NAME, TAG.TAG_ID FROM TAG INNER JOIN NEWS_TAG ON NEWS_TAG.TAG_ID = TAG.TAG_ID WHERE NEWS_TAG.NEWS_ID = ?";
	private static final String SQL_DISABLE_FK_CONSTRAINT = "alter table \"ROOT\".\"NEWS_TAG\" disable  constraint \"FK_NEWS_TAG_NEWS_NEWS_ID\"";
	private static final String TEST_TAG_NAME = "test tag 3";
	private static final String TEST_NEW_TAG_NAME = "test new";
	private static final long TEST_ID = 3;
	private static final int ONE_LINE = 1;

	private Tag testTag;
	
	@Autowired
	private ITagDao tagDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Tag> rowMapper = new RowMapper<Tag>() {
		private static final String TAG_NAME = "TAG_NAME";
		private static final String TAG_ID = "TAG_ID";

		@Override
		public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
			Tag tag = new Tag();
			tag.setTagId(rs.getLong(TAG_ID));
			tag.setTagName(rs.getString(TAG_NAME));
			return tag;
		}
	};

	@Before
	public void createTestTag() {
		testTag = new Tag();
		testTag.setTagId(TEST_ID);
		testTag.setTagName(TEST_TAG_NAME);
	}

	/*@BeforeTransaction
	public void disableConstraint() {
			LOG.info("disableConstraint");
		jdbcTemplate.execute(SQL_DISABLE_FK_CONSTRAINT);
	}*/
	
	@Ignore
	@Test
	@DatabaseSetup(value = "/test-data/tag/tag.xml", type = DatabaseOperation.INSERT)
	public void findTagByIdTest() throws DaoException {
		Tag tag = tagDao.findTagByID(TEST_ID);

		assertEquals(tag, testTag);
	}

	@Ignore
	@Test
	@DatabaseSetup(value = "/test-data/tag/tag.xml", type = DatabaseOperation.INSERT)
	public void findAllTagsTest() throws DaoException {
		int rowCount = jdbcTemplate.queryForObject(SQL_TAG_COUNT_QUERY, Integer.class);
		List<Tag> taglist = tagDao.findAllTags();

		assertEquals(rowCount, taglist.size());
	}

	@Ignore
	@Test
	@DatabaseSetup(value = "/test-data/tag/tag.xml", type = DatabaseOperation.INSERT)
	public void findAllTagsByNewsIDTest() throws DaoException {
		
		//LOG.info("Test metod");

		List<Tag> tagListExpected = jdbcTemplate.query(SQL_FIND_TAG_BY_NEWS_ID, new Object[]{TEST_ID}, rowMapper);
		
		List<Tag> tagListReal = tagDao.findAllTagsByNewsID(TEST_ID);
		
		assertEquals(tagListExpected, tagListReal);
	}

	@Ignore
	@Test
	public void addNewTagTest() throws DaoException {

		int rowCountBefore = jdbcTemplate.queryForObject(SQL_TAG_COUNT_QUERY, Integer.class);

		tagDao.addNewTag(testTag);

		int rowCountAfter = jdbcTemplate.queryForObject(SQL_TAG_COUNT_QUERY, Integer.class);

		assertEquals(rowCountBefore + ONE_LINE, rowCountAfter);
	}
	
	@Ignore
	@Test
	@DatabaseSetup(value = "/test-data/tag/tag.xml", type = DatabaseOperation.INSERT)
	public void updateTagTest() throws DaoException {

		testTag.setTagName(TEST_NEW_TAG_NAME);
		tagDao.updateTag(testTag);

		Tag tag = jdbcTemplate.queryForObject(SQL_FIND_TAG_BY_ID, rowMapper, testTag.getTagId());

		assertEquals(tag, testTag);
	}
	
	//@Ignore
	@Test
	@DatabaseSetup(value = "/test-data/tag/tag.xml", type = DatabaseOperation.INSERT)
	//@DatabaseSetup(value = "/test-data/full-database/full.xml", type = DatabaseOperation.INSERT)
	public void deleteTagTest() throws DaoException {

		int rowCountBefore = jdbcTemplate.queryForObject(SQL_TAG_COUNT_QUERY, Integer.class);

		tagDao.deleteTag(TEST_ID);

		int rowCountAfter = jdbcTemplate.queryForObject(SQL_TAG_COUNT_QUERY, Integer.class);

		assertEquals(rowCountBefore - ONE_LINE, rowCountAfter);
	}
}
