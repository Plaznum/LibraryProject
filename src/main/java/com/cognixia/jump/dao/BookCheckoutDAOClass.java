package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.BookCheckout;

public class BookCheckoutDAOClass implements BookCheckoutDAO{
	private static final Connection conn = ConnectionManager.getConnection();

	private static final String ADD_BOOKCHECKOUT = "INSERT INTO book_checkouts(patron_id, isbn, checkedout, due_date, returned) values (?, ?, ?, ?, ?)";
	private static final String SELECT_ALL_BOOKCHECKOUTS = "SELECT * FROM book_checkouts";
	private static final String SELECT_BOOKCHECKOUT_BY_ID = "SELECT * FROM book_checkouts WHERE checkout_id = ?";
	private static final String UPDATE_BOOKCHECKOUT = "UPDATE book_checkouts SET patron_id = ?, isbn = ?, checkout = ?, due_date = ?, returned = ?, where checkout_id = ?";
	private static final String DELETE_BOOKCHECKOUT = "DELETE FROM book_checkouts WHERE checkout_id = ?";
	
	@Override
	public boolean addBookCheckout(BookCheckout b) {
		try (PreparedStatement pstmt = conn.prepareStatement(ADD_BOOKCHECKOUT);){
			pstmt.setInt(1, b.getPatron_id());
			pstmt.setString(2, b.getIsbn());
			pstmt.setDate(3, b.getCheckedout());
			pstmt.setDate(4, b.getDue_date());
			pstmt.setDate(5, b.getReturned());
			if(pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<BookCheckout> getAllBookCheckouts() {
		List<BookCheckout> bookCheckouts = new ArrayList<>();
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_BOOKCHECKOUTS);
				ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()) {
				bookCheckouts.add(new BookCheckout(rs.getInt("checkout_id"), 
						rs.getInt("patron_id"), 
						rs.getString("isbn"),
						rs.getDate("checkedout"),
						rs.getDate("due_date")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bookCheckouts;
	}

	@Override
	public BookCheckout getBookCheckoutById(int id) {
		BookCheckout bookCheckout = null;
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_BOOKCHECKOUT_BY_ID);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			bookCheckout=new BookCheckout(rs.getInt("checkout_id"), 
					rs.getInt("patron_id"), 
					rs.getString("isbn"),
					rs.getDate("checkedout"),
					rs.getDate("due_date"));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bookCheckout;
	}

	@Override
	public boolean updateBookCheckout(BookCheckout b) {
		try(PreparedStatement pstmt = conn.prepareStatement(UPDATE_BOOKCHECKOUT);){
			pstmt.setInt(1, b.getPatron_id());
			pstmt.setString(2, b.getIsbn());
			pstmt.setDate(3, b.getCheckedout());
			pstmt.setDate(4, b.getDue_date());
			pstmt.setDate(5, b.getReturned());
			
			if(pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBookCheckout(int id) {
		try(PreparedStatement ptsmt = conn.prepareStatement(DELETE_BOOKCHECKOUT)){
			ptsmt.setInt(1, id);
			if(ptsmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
