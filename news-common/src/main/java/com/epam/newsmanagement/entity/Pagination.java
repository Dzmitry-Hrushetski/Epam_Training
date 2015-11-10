package com.epam.newsmanagement.entity;

import java.io.Serializable;

public class Pagination implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int newsPerScreen;
	private int totalPages;
	private int currentPage;
	
	private long totalNews;
	private long currentNewsIndex;
}
