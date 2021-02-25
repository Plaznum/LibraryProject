package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.BookCheckout;

public interface BookCheckoutDAO {
	//create
	boolean addBookCheckout(BookCheckout b);
	//read
	List<BookCheckout> getAllBookCheckouts();
	BookCheckout getBookCheckoutById(int id);
	//update
	boolean updateBookCheckout(BookCheckout b);
	//delete
	boolean deleteBookCheckout(int id);
}
