package com.epam.newsmanagement.entity;

import java.io.Serializable;
import java.util.List;

public class SerarchCriteria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Author author;
	private List<Tag> tagList;
	
	public List<Tag> getTagList() {
		return tagList;
	}
	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	@Override
	public int hashCode() {
		final int prime = 61;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((tagList == null) ? 0 : tagList.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SerarchCriteria other = (SerarchCriteria) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (tagList == null) {
			if (other.tagList != null)
				return false;
		} else if (!tagList.equals(other.tagList))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SerarchCriteria [author=" + author + ", tagList=" + tagList + "]";
	}
}
