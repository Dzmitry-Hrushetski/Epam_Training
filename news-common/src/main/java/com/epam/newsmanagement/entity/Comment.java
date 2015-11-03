package com.epam.newsmanagement.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The Class Comment.
 *
 * @author Dzmitry Hrushetski
 */
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	private long commentId;
	private long newsId;
	private String commentText;
	private Timestamp creationTimestamp;
	
	/**
	 * Gets the comment id.
	 *
	 * @return the comment id
	 */
	public long getCommentId() {
		return commentId;
	}

	/**
	 * Sets the comment id.
	 *
	 * @param commentId the new comment id
	 */
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	
	/**
	 * Gets the news id.
	 *
	 * @return the id news
	 */
	public long getNewsId() {
		return newsId;
	}
	
	/**
	 * Sets the news id.
	 *
	 * @param newsId the new id news
	 */
	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}
	
	/**
	 * Gets the comment text.
	 *
	 * @return the comment text
	 */
	public String getCommentText() {
		return commentText;
	}
	
	/**
	 * Sets the comment text.
	 *
	 * @param commentText the new comment text
	 */
	public void setCommentText(String commentText) {
		this.commentText = commentText;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 56;
		int result = 1;
		result = prime * result + (int) (commentId ^ (commentId >>> 32));
		result = prime * result + ((commentText == null) ? 0 : commentText.hashCode());
		result = prime * result + ((creationTimestamp == null) ? 0 : creationTimestamp.hashCode());
		result = prime * result + (int) (newsId ^ (newsId >>> 32));
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
		Comment other = (Comment) obj;
		if (commentId != other.commentId)
			return false;
		if (commentText == null) {
			if (other.commentText != null)
				return false;
		} else if (!commentText.equals(other.commentText))
			return false;
		if (creationTimestamp == null) {
			if (other.creationTimestamp != null)
				return false;
		} else if (!creationTimestamp.equals(other.creationTimestamp))
			return false;
		if (newsId != other.newsId)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", newsId=" + newsId + ", commentText=" + commentText
				+ ", creationTimestamp=" + creationTimestamp + "]";
	}
}
