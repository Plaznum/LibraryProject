package com.cognixia.jump.model;

import java.sql.Date;

public class Book {
	private String isbn;
	private String title;
	private String descr;
	private boolean rented;
	private Date addedToLibrary;
	
	public Book(String isbn, String title, String descr, boolean rented, Date addedToLibrary) {
		this.isbn = isbn;
		this.title = title;
		this.descr = descr;
		this.rented = rented;
		this.addedToLibrary = addedToLibrary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getAddedToLibrary() {
		return addedToLibrary;
	}

	public void setAddedToLibrary(Date addedToLibrary) {
		this.addedToLibrary = addedToLibrary;
	}

	public String getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", descr=" + descr + ", rented=" + rented
				+ ", addedToLibrary=" + addedToLibrary + "]";
	}
}
