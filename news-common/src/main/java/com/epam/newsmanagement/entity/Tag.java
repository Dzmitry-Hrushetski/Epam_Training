package com.epam.newsmanagement.entity;

import java.io.Serializable;

/**
 * The Class Tag.
 *
 * @author Dzmitry Hrushetski
 */
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;
	private long tagId;
	private String tagName;
	
	/**
	 * Gets the tag id.
	 *
	 * @return the tag id
	 */
	public long getTagId() {
		return tagId;
	}

	/**
	 * Sets the tag id.
	 *
	 * @param tagId the new tag id
	 */
	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	/**
	 * Gets the tag name.
	 *
	 * @return the tag name
	 */
	public String getTagName() {
		return tagName;
	}
	
	/**
	 * Sets the tag name.
	 *
	 * @param tagName the new tag name
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 59;
		int result = 1;
		result = prime * result + (int) (tagId ^ (tagId >>> 32));
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
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
		Tag other = (Tag) obj;
		if (tagId != other.tagId)
			return false;
		if (tagName == null) {
			if (other.tagName != null)
				return false;
		} else if (!tagName.equals(other.tagName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", tagName=" + tagName + "]";
	}
}
