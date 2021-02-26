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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.LibrarianDAO;
import com.cognixia.jump.dao.LibrarianDAOClass;
import com.cognixia.jump.dao.PatronDAO;
import com.cognixia.jump.dao.PatronDAOClass;
import com.cognixia.jump.model.Librarian;
import com.cognixia.jump.model.Patron;

@WebServlet("/LibrarianServlet")
public class LibrarianServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private LibrarianDAO db;
	private PatronDAO db1;
	private PreparedStatement ptsmt;
	private Connection conn;
	
	@Override
	public void init() throws ServletException {
		this.db = new LibrarianDAOClass();
		this.db1 = new PatronDAOClass();
		conn = ConnectionManager.getConnection();
		try {
			ptsmt = conn.prepareStatement("SELECT * FROM librarians WHERE username = ? AND pass = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("username");
		String pass = req.getParameter("password");
		
		String libcheck = ".+(@library\\.com)$";
		boolean retrieved = false;
		
		
		if(!email.matches(libcheck)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("PatronServlet");
			dispatcher.forward(req, resp);
		} else {
			try {
				ptsmt.setString(1, email);
				ptsmt.setString(2, pass);
				
				retrieved = ptsmt.execute();
				
				if(retrieved) {
					List<Patron> patrons = new ArrayList<Patron>();
					
					patrons = db1.getAllPatrons();
					
					req.setAttribute("patrons", patrons);
					RequestDispatcher dispatcher = req.getRequestDispatcher("/librarian.jsp");
					dispatcher.forward(req, resp);
					
				} else {
					//wrong password or username 
					return;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		//freeze and unfreeze
		if(req.getParameter("changeStatus") != null) {
			//get patron id from button
			int id = Integer.parseInt(req.getParameter("changeStatus"));
			
			Patron patron = db1.getPatronById(id);
			System.out.println(patron.toString());
			patron.setAccount_frozen(!patron.isAccount_frozen());
			
			boolean bool = db1.updatePatron(patron);
			System.out.println(bool);
			System.out.println(patron.toString());
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/");
			dispatcher.forward(req, resp);
			return;
		} else {
		//login or signup button verification
		if(req.getParameter("action").equals("login")) {
				//login verification 
				if(req.getParameter("firstname") == null) {
				doGet(req, resp);
				return;
				}
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/newuser.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		
		
				//update
				String username = req.getParameter("username");
				String pass = req.getParameter("password");
				Librarian librarian = new Librarian(0,username, pass);
				
				db.addLibrarian(librarian);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/");
				dispatcher.forward(req, resp);
		}
	}
	
}
