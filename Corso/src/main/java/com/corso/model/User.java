package com.corso.model;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String email;
	private int age;
	private String dateOfBirth;
	private String country;
	
	
	public User() {
		
	}


	public User(int id, String name, String email, int age, String dateOfBirth, String country) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(String date) {
		this.dateOfBirth = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Utente [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", dateOfBirth="
				+ dateOfBirth + ", country=" + country + "]";
	}

}
