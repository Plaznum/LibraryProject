package com.cognixia.jump.model;

import java.sql.Date;

public class BookCheckout {
	private int checkout_id;
	private int patron_id;
	private String isbn;
	private Date checkedout;
	private Date due_date;
	private Date returned;
	
	public BookCheckout(int checkout_id, int patron_id, String isbn, Date checkedout, Date due_date) {
		super();
		this.checkout_id = checkout_id;
		this.patron_id = patron_id;
		this.isbn = isbn;
		this.checkedout = checkedout;
		this.due_date = due_date;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getCheckedout() {
		return checkedout;
	}

	public void setCheckedout(Date checkedout) {
		this.checkedout = checkedout;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public Date getReturned() {
		return returned;
	}

	public void setReturned(Date returned) {
		this.returned = returned;
	}

	public int getPatron_id() {
		return patron_id;
	}

	public int getCheckout_id() {
		return checkout_id;
	}

	@Override
	public String toString() {
		return "BookCheckout [patron_id=" + patron_id + ", checkout_id=" + checkout_id + ", isbn=" + isbn
				+ ", checkedout=" + checkedout + ", due_date=" + due_date + ", returned=" + returned + "]";
	}
}
