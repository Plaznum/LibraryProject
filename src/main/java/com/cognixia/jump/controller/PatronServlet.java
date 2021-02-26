package com.cognixia.jump.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.PatronDAO;
import com.cognixia.jump.dao.PatronDAOClass;
import com.cognixia.jump.model.Patron;


public class PatronServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private PatronDAO db;
	private PreparedStatement ptsmt;
	private Connection conn;
	
	@Override
	public void init() throws ServletException {
		this.db = new PatronDAOClass();
		conn = ConnectionManager.getConnection();
		try {
			ptsmt = conn.prepareStatement("SELECT * FROM patrons WHERE username = ? AND pass = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("username");
		String pass = req.getParameter("password");
		
		try {
			ptsmt.setString(1, email);
			ptsmt.setString(2, pass);

			ResultSet rs = ptsmt.executeQuery();
			
			rs.next();
			req.setAttribute("patronid", rs.getInt("patron_id"));
			req.setAttribute("firstname", rs.getString("first_name"));
			req.setAttribute("lastname", rs.getString("last_name"));
			req.setAttribute("username", rs.getString("username"));
			req.setAttribute("password", rs.getString("pass"));
			
			if(rs != null) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/patron.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//login verification 
		if(req.getParameter("firstname") == null) {
		doGet(req, resp);
		return;
		}
		
		//sign up and update
		String first_name = req.getParameter("firstname");
		String last_name = req.getParameter("lastname");
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		Patron patron = new Patron(0, first_name, last_name, username, pass, true);

		db.addPatron(patron);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/");
		dispatcher.forward(req, resp);
	}
}
