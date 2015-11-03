package com.epam.newsmanagement.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.epam.newsmanagement.dao.impl.TagDaoImpl;
import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;
import com.epam.newsmanagement.service.ITagService;

//@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class TagServiceImpl implements ITagService {
	//private static final Logger LOG = Logger.getLogger(TagServiceImpl.class);
	
	private TagDaoImpl tagDao;

	public TagDaoImpl getTagDao() {
		return tagDao;
	}

	public void setTagDao(TagDaoImpl tagDao) {
		this.tagDao = tagDao;
	}

	@Override
	public List<Tag> findAllTags() throws ServiceException {
		List<Tag> tagsList = null;
		try {
			tagsList = tagDao.findAllTags();
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
		return tagsList;
	}

	@Override
	public List<Tag> findAllTagsByNewsID(Long newsId) throws ServiceException {
		List<Tag> tagsList = null;
		try {
			tagsList = tagDao.findAllTagsByNewsID(newsId);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
		return tagsList;
	}

	@Override
	public void addNewTag(Tag tag) throws ServiceException {
		try {
			tagDao.addNewTag(tag);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
	}

	@Override
	public void updateTag(Tag tag) throws ServiceException {
		try {
			tagDao.updateTag(tag);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
	}

	@Override
	public void deleteTag(Long tagId) throws ServiceException {
		try {
			tagDao.deleteTag(tagId);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void updateTagListByNews(Long newsId, List<Tag> tagList) throws ServiceException {
		try {
			tagDao.detachAllTagsFromNews(newsId);
			for(Tag tag: tagList) {
				tagDao.linkTagWithNews(newsId, tag.getTagId());
			}
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
	}
}
