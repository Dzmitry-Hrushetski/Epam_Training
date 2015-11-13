package com.epam.newsmanagement.entity;

import java.io.Serializable;

public class Pagination implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int newsPerScreen;
	private int totalPages;
	private int currentPage;
	
	private long totalNews;
	private long currentNewsIndex;
	
	public int getNewsPerScreen() {
		return newsPerScreen;
	}
	public void setNewsPerScreen(int newsPerScreen) {
		this.newsPerScreen = newsPerScreen;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public long getTotalNews() {
		return totalNews;
	}
	public void setTotalNews(long totalNews) {
		this.totalNews = totalNews;
	}
	public long getCurrentNewsIndex() {
		return currentNewsIndex;
	}
	public void setCurrentNewsIndex(long currentNewsIndex) {
		this.currentNewsIndex = currentNewsIndex;
	}
}
