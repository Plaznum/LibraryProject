package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Book;

public class BookDAOClass implements BookDAO {

	private static final Connection conn = ConnectionManager.getConnection();
	
	private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";
	private static final String SELECT_BOOK_BY_ISBN = "SELECT * FROM books WHERE isbn=?";
	private static final String ADD_BOOK = "INSERT INTO books(title, descr, rented, addedToLibrary) values(?,?,?,?)";
	private static final String UPDATE_BOOK = "UPDATE books SET title=?, descr=?, rented=? addedToLibrary=? WHERE isbn=? RETURNING *";
	private static final String DELETE_BOOK = "DELETE FROM books WHERE isbn=? RETURNING *";
	
	@Override
	public boolean addBook(Book b) {
		try(PreparedStatement pstmt = conn.prepareStatement(ADD_BOOK)){
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getDescr());
			pstmt.setBoolean(3, b.isRented());
			pstmt.setDate(4, b.getAddedToLibrary());
			if(pstmt.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_BOOKS);
			ResultSet rs = pstmt.executeQuery();){
			
			while(rs.next()) {
				books.add(new Book(rs.getString("isbn"), 
									  rs.getString("title"), 
									  rs.getString("descr"),
									  rs.getBoolean("rented"),
									  rs.getDate("added_to_library")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book getBookById(String isbn) {
		Book book = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_BOOK_BY_ISBN);){
			
			pstmt.setString(1, isbn);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			book = new Book(rs.getString("isbn"), 
						    rs.getString("title"), 
						    rs.getString("descr"),
						    rs.getBoolean("rented"),
						    rs.getDate("added_to_library"));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return book;
	}

	@Override
	public Book updateBook(Book b) {
		Book book = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_BOOK);){	
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getDescr());
			pstmt.setBoolean(3, b.isRented());
			pstmt.setDate(4, b.getAddedToLibrary());
			pstmt.setString(5, b.getIsbn());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			book = new Book(rs.getString("isbn"), 
						    rs.getString("title"), 
						    rs.getString("descr"),
						    rs.getBoolean("rented"),
						    rs.getDate("added_to_library"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return book;
	}

	@Override
	public Book deleteBook(String isbn) {
		
		Book book = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement(DELETE_BOOK);){
			
			pstmt.setString(1, isbn);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			book = new Book(rs.getString("isbn"), 
						    rs.getString("title"), 
						    rs.getString("descr"),
						    rs.getBoolean("rented"),
						    rs.getDate("added_to_library"));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return book;
	}

}
