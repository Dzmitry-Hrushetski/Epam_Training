package com.epam.newsmanagement.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The Class Author.
 *
 * @author Dzmitry Hrushetski
 */
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;
	private long authorId;
	private String authorName;
	private Timestamp expiredTimestamp;
		
	
	/**
	 * Gets the author id.
	 *
	 * @return the author id
	 */
	public long getAuthorId() {
		return authorId;
	}
	
	
	/**
	 * Sets the author id.
	 *
	 * @param autorId the new author id
	 */
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	
	/**
	 * Gets the author name.
	 *
	 * @return the author name
	 */
	public String getAuthorName() {
		return authorName;
	}
	
	/**
	 * Sets the author name.
	 *
	 * @param autorName the new author name
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	/**
	 * Gets the expired timestamp.
	 *
	 * @return the expired timestamp
	 */
	public Timestamp getExpiredTimestamp() {
		return expiredTimestamp;
	}
	
	/**
	 * Sets the expired timestamp.
	 *
	 * @param expiredTimestamp the new expired timestamp
	 */
	public void setExpiredTimestamp(Timestamp expiredTimestamp) {
		this.expiredTimestamp = expiredTimestamp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 55;
		int result = 1;
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + ((expiredTimestamp == null) ? 0 : expiredTimestamp.hashCode());
		result = prime * result + (int) (authorId ^ (authorId >>> 32));
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
		Author other = (Author) obj;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		if (expiredTimestamp == null) {
			if (other.expiredTimestamp != null)
				return false;
		} else if (!expiredTimestamp.equals(other.expiredTimestamp))
			return false;
		if (authorId != other.authorId)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", expiredTimestamp=" + expiredTimestamp
				+ "]";
	}	
}
