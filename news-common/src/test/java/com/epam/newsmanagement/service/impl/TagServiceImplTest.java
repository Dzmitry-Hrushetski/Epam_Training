package com.epam.newsmanagement.service.impl;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.epam.newsmanagement.dao.impl.TagDaoImpl;
import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;


@RunWith(MockitoJUnitRunner.class)
public class TagServiceImplTest {
	
	@Mock private TagDaoImpl tagDao;
    @InjectMocks private TagServiceImpl tagService;

	@Test
	public void addNewTagTest() throws ServiceException, DaoException {
		Tag tag = any(Tag.class);
		tagService.addNewTag(tag);
		
		verify(tagDao).addNewTag(tag);
	}
	
	@Test(expected=ServiceException.class)
	public void addNewTagExceptionTest() throws ServiceException, DaoException {
		doThrow(DaoException.class).when(tagDao).addNewTag(any(Tag.class));
				
		tagService.addNewTag(any(Tag.class));
	}

}
