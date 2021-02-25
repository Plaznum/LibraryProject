package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Librarian;

public class LibrarianDAOClass implements LibrarianDAO{
	
	private static final Connection conn = ConnectionManager.getConnection();

	private static final String ADD_LIBRARIAN = "INSERT INTO librarians(username, password) values (?, ?, ?)";
	private static final String SELECT_ALL_LIBRARIANS = "SELECT * FROM librarians";
	private static final String SELECT_LIBRARIAN_BY_ID = "SELECT * FROM librarians WHERE id = ?";
	private static final String UPDATE_LIBRARIAN = "UPDATE librarians SET username = ?, password = ?, where id = ?";
	private static final String DELETE_LIBRARIAN = "DELETE FROM librarians WHERE id = ?";
	
	@Override
	public boolean addLibrarian(Librarian l) {
		try (PreparedStatement pstmt = conn.prepareStatement(ADD_LIBRARIAN);){
			pstmt.setString(1, l.getUsername());
			pstmt.setString(2, l.getPassword());
			if(pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Librarian> getAllLibrarians() {
		List<Librarian> librarians = new ArrayList<>();
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_LIBRARIANS);
				ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()) {
				librarians.add(new Librarian(rs.getInt("id"), 
						rs.getString("username"), 
						rs.getString("password")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return librarians;
	}

	@Override
	public Librarian getLibrarianById(int id) {
		Librarian librarian = null;
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_LIBRARIAN_BY_ID);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			librarian=new Librarian(rs.getInt("id"), 
						rs.getString("username"), 
						rs.getString("password"));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return librarian;
	}

	@Override
	public boolean updateLibrarian(Librarian l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLibrarian(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
