package com.cognixia.jump.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.LibrarianDAO;
import com.cognixia.jump.dao.LibrarianDAOClass;
import com.cognixia.jump.model.Librarian;
import com.cognixia.jump.model.Patron;

public class LibrarianServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private LibrarianDAO db;
	private PreparedStatement ptsmt;
	private Connection conn;
	
	@Override
	public void init() throws ServletException {
		this.db = new LibrarianDAOClass();
		conn = ConnectionManager.getConnection();
		try {
			ptsmt = conn.prepareStatement("SELECT * FROM librarian WHERE username = ? AND pass = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("username");
		String pass = req.getParameter("password");
		
		String libcheck = ".+(@librarian\\.com)$";
		boolean retrieved = false;
		
		if(email != libcheck) {
			//forward to patron post
		} else {
			try {
				ptsmt.setString(1, email);
				ptsmt.setString(2, pass);
				
				retrieved = ptsmt.execute();
				
				if(retrieved) {
					RequestDispatcher dispatcher = req.getRequestDispatcher("/librarian.jsp");
					dispatcher.forward(req, resp);
				} else {
					//wrong password or username 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("username");
		String pass = req.getParameter("password");
		
		String libcheck = ".+(@librarian\\.com)$";
		boolean retrieved = false;
		
		if(email != libcheck) {
			//forward to patron post
		} else {
			try {
				ptsmt.setString(1, email);
				ptsmt.setString(2, pass);
				
				retrieved = ptsmt.execute();
				
				if(retrieved) {
					RequestDispatcher dispatcher = req.getRequestDispatcher("/librarian.jsp");
					dispatcher.forward(req, resp);
				} else {
					//wrong password or username 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
}
