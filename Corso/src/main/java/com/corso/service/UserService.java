package com.corso.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.corso.model.User;

public interface UserService {

	public void creaUtente(String name, String email, int age, String dateOfBirth, String country) throws ValidationUserException;
	public void modificaUtente(int id, String name, String email, int age, String dateOfBirth, String country) throws ValidationUserException;
	public List<User> visualizzaUtenti();
	public void cancellaUtente(int id);
	public void errorMessage(SQLException ex);
}
