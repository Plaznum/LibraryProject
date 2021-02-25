package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Patron;

public interface PatronDAO {
		//create
		boolean addPatron(Patron p);
		//read
		List<Patron> getAllPatrons();
		Patron getPatronById(int id);
		//update
		boolean updatePatron(Patron p);
		//delete
		boolean deletePatron(int id);
}
