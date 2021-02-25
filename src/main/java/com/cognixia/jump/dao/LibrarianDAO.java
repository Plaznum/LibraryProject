package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Librarian;

public interface LibrarianDAO {
	//create
	boolean addLibrarian(Librarian l);
	//read
	List<Librarian> getAllLibrarians();
	Librarian getLibrarianById(int id);
	//update
	boolean updateLibrarian(Librarian l);
	//delete
	boolean deleteLibrarian(int id);
}
