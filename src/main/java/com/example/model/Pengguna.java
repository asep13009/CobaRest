package com.example.model;

public class Pengguna {
	String name;
	String email;
	public Pengguna() {
		// TODO Auto-generated constructor stub
	}
	
	public Pengguna(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
