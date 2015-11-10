package com.epam.newsmanagement.entity;

import java.io.Serializable;
import java.util.List;

/**
 * The Class NewsData.
 *
 * @author Dzmitry Hrushetski
 */
public class NewsData implements Serializable {
	private static final long serialVersionUID = 1L;
	private News news;
	private Author autor;
	private List<Tag> tags;
	private List<Comment> comments;
	
	/**
	 * Gets the news.
	 *
	 * @return the news
	 */
	public News getNews() {
		return news;
	}
	
	/**
	 * Sets the news.
	 *
	 * @param news the new news
	 */
	public void setNews(News news) {
		this.news = news;
	}
	
	/**
	 * Gets the autor.
	 *
	 * @return the autor
	 */
	public Author getAutor() {
		return autor;
	}
	
	/**
	 * Sets the autor.
	 *
	 * @param autor the new autor
	 */
	public void setAutor(Author autor) {
		this.autor = autor;
	}
	
	/**
	 * Gets the tags.
	 *
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}
	
	/**
	 * Sets the tags.
	 *
	 * @param tags the new tags
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}
	
	/**
	 * Sets the comments.
	 *
	 * @param comments the new comments
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 58;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((news == null) ? 0 : news.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewsData other = (NewsData) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (news == null) {
			if (other.news != null)
				return false;
		} else if (!news.equals(other.news))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}
}
