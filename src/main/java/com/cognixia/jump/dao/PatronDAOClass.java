package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Patron;

public class PatronDAOClass implements PatronDAO{

	private static final Connection conn = ConnectionManager.getConnection();
	
	private static final String SELECT_ALL_PATRONS = "SELECT * FROM patrons";
	private static final String SELECT_PATRON_BY_ID = "SELECT * FROM patrons WHERE id = ?";
	private static final String ADD_PATRON = "INSERT INTO "
			+ "patrons(first_name, last_name, username_name, pass, account_frozen,) "
			+ "values (?, ?, ?, ?, true)";
	private static final String UPDATE_PATRON = "UPDATE patrons "
			+ "SET first_name = ?, last_name = ?, username_name = ?, pass = ?, account_frozen = ?, where id = ?";
	private static final String DELETE_PATRON = "DELETE FROM patrons WHERE id = ?";
	
	@Override
	public boolean addPatron(Patron p) {
		try(PreparedStatement ptsmt = conn.prepareStatement(ADD_PATRON);){
			ptsmt.setString(1, p.getFirst_name());
			ptsmt.setString(2, p.getLast_name());
			ptsmt.setString(3, p.getUsername());
			ptsmt.setString(4, p.getPassword());
			
			
			if(ptsmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			
		}
		return false;
	}

	@Override
	public List<Patron> getAllPatrons() {
		List<Patron> products = new ArrayList<>();
		
		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_PATRONS);
				ResultSet rs = pstmt.executeQuery();){
			
			while (rs.next()) {
				products.add(new Patron(rs.getInt("patron_id"), 
											rs.getString("first_name"), 
											rs.getString("last_name"), 
											rs.getString("username_name"), 
											rs.getString("pass"),
											rs.getBoolean("account_frozen")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public Patron getPatronById(int id) {
		Patron patron = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_PATRON_BY_ID);){
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			patron = new Patron(rs.getInt("patron_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getString("username_name"), 
						rs.getString("pass"),
						rs.getBoolean("account_frozen"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return patron;
	}

	@Override
	public boolean updatePatron(Patron p) {
		try(PreparedStatement ptsmt = conn.prepareStatement(UPDATE_PATRON);){
			ptsmt.setString(1, p.getFirst_name());
			ptsmt.setString(2, p.getLast_name());
			ptsmt.setString(3, p.getUsername());
			ptsmt.setString(4, p.getPassword());
			ptsmt.setBoolean(5,  p.isAccount_frozen());
			
			
			if(ptsmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			
		}
		return false;
	}

	@Override
	public boolean deletePatron(int id) {
		try(PreparedStatement ptsmt = conn.prepareStatement(DELETE_PATRON)){
			ptsmt.setInt(1, id);
			if(ptsmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			
		}
		return false;
	}
	
}
