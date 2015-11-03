package com.epam.newsmanagement.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The Class News.
 *
 * @author Dzmitry Hrushetski
 */
public class News implements Serializable {
	private static final long serialVersionUID = 1L;
	private long newsId;
	private String title;
	private String shortText;
	private String fullText;
	private Timestamp creationTimestamp;
	private Timestamp modificationTimestamp;
	
		
	/**
	 * Gets the news id.
	 *
	 * @return the news id
	 */
	public long getNewsId() {
		return newsId;
	}

	/**
	 * Sets the news id.
	 *
	 * @param newsId the new news id
	 */
	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the short text.
	 *
	 * @return the short text
	 */
	public String getShortText() {
		return shortText;
	}
	
	/**
	 * Sets the short text.
	 *
	 * @param shortText the new short text
	 */
	public void setShortText(String shortText) {
		this.shortText = shortText;
	}
	
	/**
	 * Gets the full text.
	 *
	 * @return the full text
	 */
	public String getFullText() {
		return fullText;
	}
	
	/**
	 * Sets the full text.
	 *
	 * @param fullText the new full text
	 */
	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	
	/**
	 * Gets the creation timestamp.
	 *
	 * @return the creation timestamp
	 */
	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}
	
	/**
	 * Sets the creation timestamp.
	 *
	 * @param creationTimestamp the new creation timestamp
	 */
	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	
	/**
	 * Gets the modification timestamp.
	 *
	 * @return the modification timestamp
	 */
	public Timestamp getModificationTimestamp() {
		return modificationTimestamp;
	}
	
	/**
	 * Sets the modification timestamp.
	 *
	 * @param modificationTimestamp the new modification timestamp
	 */
	public void setModificationTimestamp(Timestamp modificationTimestamp) {
		this.modificationTimestamp = modificationTimestamp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 57;
		int result = 1;
		result = prime * result + ((creationTimestamp == null) ? 0 : creationTimestamp.hashCode());
		result = prime * result + ((fullText == null) ? 0 : fullText.hashCode());
		result = prime * result + ((modificationTimestamp == null) ? 0 : modificationTimestamp.hashCode());
		result = prime * result + (int) (newsId ^ (newsId >>> 32));
		result = prime * result + ((shortText == null) ? 0 : shortText.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		News other = (News) obj;
		if (creationTimestamp == null) {
			if (other.creationTimestamp != null)
				return false;
		} else if (!creationTimestamp.equals(other.creationTimestamp))
			return false;
		if (fullText == null) {
			if (other.fullText != null)
				return false;
		} else if (!fullText.equals(other.fullText))
			return false;
		if (modificationTimestamp == null) {
			if (other.modificationTimestamp != null)
				return false;
		} else if (!modificationTimestamp.equals(other.modificationTimestamp))
			return false;
		if (newsId != other.newsId)
			return false;
		if (shortText == null) {
			if (other.shortText != null)
				return false;
		} else if (!shortText.equals(other.shortText))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", title=" + title + ", shortText=" + shortText + ", fullText=" + fullText
				+ ", creationTimestamp=" + creationTimestamp + ", modificationTimestamp=" + modificationTimestamp + "]";
	}
}
