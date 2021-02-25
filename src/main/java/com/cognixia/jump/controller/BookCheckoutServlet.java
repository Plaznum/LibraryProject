package com.cognixia.jump.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.dao.BookCheckoutDAO;
import com.cognixia.jump.dao.BookCheckoutDAOClass;
import com.cognixia.jump.model.BookCheckout;

/**
 * Servlet implementation class BookCheckoutServlet
 */
public class BookCheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BookCheckoutDAO db;
	
	@Override
	public void init() throws ServletException {
		this.db = new BookCheckoutDAOClass();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String patron_id = request.getParameter("patron_id");
		List<BookCheckout> bookCheckouts = new ArrayList<BookCheckout>();
		
		if(patron_id == null) {
			bookCheckouts = db.getAllBookCheckouts();
		} else {
			bookCheckouts.add(db.getBookCheckoutById(Integer.parseInt(patron_id)));
		}
		
		request.setAttribute("book_checkouts", bookCheckouts);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/bookcheckouts.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int patron_id = Integer.parseInt(request.getParameter("patron_id"));
		String isbn = request.getParameter("isbn");
		Date checkedout = Date.valueOf(request.getParameter("checkedout"));
		Date due_date = Date.valueOf(request.getParameter("due_date"));
		
		BookCheckout bookCheckout = new BookCheckout(0, patron_id, isbn, checkedout, due_date);
		
		db.addBookCheckout(bookCheckout);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
	}

}
