package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Book;

public interface BookDAO {
	//create
	boolean addBook(Book p);
	//read
	List<Book> getAllBooks();
	Book getBookById(String isbn);
	//update
	Book updateBook(Book p);
	//delete
	Book deleteBook(String isbn);
}
