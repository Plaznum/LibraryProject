package com.cognixia.jump.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.dao.PatronDAO;
import com.cognixia.jump.dao.PatronDAOClass;
import com.cognixia.jump.model.Patron;

public class PatronServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private PatronDAO db;
	
	@Override
	public void init() throws ServletException {
		this.db = new PatronDAOClass();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = req.getParameter("patron_id");
//		List<Patron> patrons = new ArrayList<Patron>();
//		
//		if(id == null) {
//			patrons = db.getAllPatrons();
//		} else {
//			patrons.add(db.getPatronById(Integer.parseInt(id)));
//		}
//		
//		req.setAttribute("products", patrons);
//		
//		System.out.println(patrons);
//		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/viewproduct.jsp");
//		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
