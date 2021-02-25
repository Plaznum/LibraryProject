package com.cognixia.jump.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.dao.BookDAO;
import com.cognixia.jump.dao.BookDAOClass;
import com.cognixia.jump.model.Book;
import com.cognixia.jump.model.Librarian;


public class BookServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private BookDAO db;
	private PreparedStatement ptsmt;
	private Connection conn;
	
	@Override
	public void init() throws ServletException {
		this.db = new BookDAOClass();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		List<Book> books = new ArrayList<Book>();
		
		if (id == null ) {
			 books = db.getAllBooks();
		} else {
			books.add(db.getBookById(id)); 
		}
		
		
		req.setAttribute("books", books);

		System.out.println(books);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/viewbook.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//add or update
		boolean exists = false;
		long millis=System.currentTimeMillis();
		Date addDate = new Date(millis);
		if(exists){
			String title = req.getParameter("title");
			String desc = req.getParameter("description");
			Book book = new Book("123", title, desc, false, addDate);
			db.updateBook(book);
			
		} else {
			String title = req.getParameter("title");
			String desc = req.getParameter("description");
			Book book = new Book("123", title, desc, false, addDate);
			db.addBook(book);
			
		}
				
		
	}
	
}
