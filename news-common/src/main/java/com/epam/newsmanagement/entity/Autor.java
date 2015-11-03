package com.epam.newsmanagement.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The Class Autor.
 *
 * @author Dzmitry Hrushetski
 */
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;
	private long autorId;
	private String autorName;
	private Timestamp expiredTimestamp;
		
	
	/**
	 * Gets the autor id.
	 *
	 * @return the autor id
	 */
	public long getAutorId() {
		return autorId;
	}
	
	
	/**
	 * Sets the autor id.
	 *
	 * @param autorId the new autor id
	 */
	public void setAutorId(long autorId) {
		this.autorId = autorId;
	}
	
	/**
	 * Gets the autor name.
	 *
	 * @return the autor name
	 */
	public String getAutorName() {
		return autorName;
	}
	
	/**
	 * Sets the autor name.
	 *
	 * @param autorName the new autor name
	 */
	public void setAutorName(String autorName) {
		this.autorName = autorName;
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
		result = prime * result + ((autorName == null) ? 0 : autorName.hashCode());
		result = prime * result + ((expiredTimestamp == null) ? 0 : expiredTimestamp.hashCode());
		result = prime * result + (int) (autorId ^ (autorId >>> 32));
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
		Autor other = (Autor) obj;
		if (autorName == null) {
			if (other.autorName != null)
				return false;
		} else if (!autorName.equals(other.autorName))
			return false;
		if (expiredTimestamp == null) {
			if (other.expiredTimestamp != null)
				return false;
		} else if (!expiredTimestamp.equals(other.expiredTimestamp))
			return false;
		if (autorId != other.autorId)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Autor [autorId=" + autorId + ", autorName=" + autorName + ", expiredTimestamp=" + expiredTimestamp
				+ "]";
	}	
}
