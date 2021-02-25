package com.cognixia.jump.model;

public class Librarian {
	
	private int id;
	private String username;
	private String password;
	
	public Librarian() {}
	
	public Librarian(int id, String username, String password){
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Librarian [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}