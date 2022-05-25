package com.corso.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.corso.config.ConnectionDB;
import com.corso.model.User;

public class UserServiceImpl implements UserService {
	ConnectionDB db;
	
	public UserServiceImpl() {
		db=new ConnectionDB();
	}
	
	private String INSERISCI_UTENTE = "INSERT INTO utente (name,email,age,dateOfBirth,country) VALUES (?, ? , ? , ?, ?);";
	private String VISUALIZZA_UTENTI = "SELECT * from utente";
	private String CANCELLA_UTENTE_ID = "DELETE from utente WHERE id= ?";
	private String MODIFICA_UTENTE_ID = "UPDATE utente set name= ? , email = ? , age =? , dateOfBirth =? , country = ? WHERE id=? ";
	
	public void creaUtente(String name, String email, int age, String dateOfBirth, String country) throws ValidationUserException {
		if(name == null || age <=0 || age >130 || dateOfBirth ==null || country == null) {
			throw new ValidationUserException("Uno o più campi risultano vuoti ");
		} 
		Connection connection=null;
		PreparedStatement statement = null;
		try {
			connection= db.getConnection();
			statement = connection.prepareStatement(INSERISCI_UTENTE);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setInt(3, age);
			statement.setDate(4, java.sql.Date.valueOf(dateOfBirth));
			statement.setString(5, country);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Un nuovo utente è stato inserito al DB");
			}
		} catch (SQLException ex) {
			errorMessage(ex);
		}
		finally{
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				
				errorMessage(e);
			}
		}
	}
	public User getUser(int id) {
		Connection connection;
		PreparedStatement statement;
		ResultSet result;
		User user = null;
		try {
			connection = db.getConnection();
			if (db != null) {
				String QUERY = "SELECT * FROM utente WHERE id=?";
				statement = db.getConnection().prepareStatement(QUERY);
				statement.setInt(1, id);
				result = statement.executeQuery();
				if (result.next()) {
					user = new User (); 
					user.setId(result.getInt(1));
					user.setName(result.getString(2));
					user.setEmail(result.getString(3));
					user.setAge(result.getInt(4));
					user.setDateOfBirth(result.getString(5));
					user.setCountry(result.getString(6));
					System.out.println("user : " + user);
				}
			}
		} catch (SQLException e) {
			errorMessage(e);
		}
		return user;
	}
	public int addUser(User user) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement statement = null;
		String INSERISCI_UTENTE = "INSERT INTO utente (id,name,email,age,dateOfBirth,country) VALUES (?, ?, ? , ? , ?, ?)";
		int result = 0;
	
		
			
			try {
				connection= db.getConnection();
				statement = connection.prepareStatement(INSERISCI_UTENTE);
				statement.setInt(1,1);
				statement.setString(2,user.getName());
				statement.setString(3,user.getEmail());
				statement.setInt(4,user.getAge());
				statement.setString(5,user.getDateOfBirth());
				statement.setString(6,user.getEmail());
				
				result = statement.executeUpdate();
				
			} catch (SQLException e) {
				
				errorMessage(e);
			}
		return result;
	}

	public void modificaUtente(int id, String name, String email, int age, String dateOfBirth, String country) throws ValidationUserException {
		if(name == null || age <=0 || age>130 || dateOfBirth ==null || country == null) {
			throw new ValidationUserException("Il campo del nome non può essere modificato poichè nullo ");
		}
		Connection connection=null;
		PreparedStatement statement = null;
		try {
			connection= db.getConnection();
			statement = connection.prepareStatement(MODIFICA_UTENTE_ID);
			statement.setInt(6, id);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setInt(3, age);
			statement.setDate(4, java.sql.Date.valueOf(dateOfBirth));      
			statement.setString(5, country);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("L'utente è stato modificato");
			}

		} catch (SQLException e) {

			errorMessage(e);
		}
		finally{
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				
				errorMessage(e);
			}
		}

	}

	public List<User> visualizzaUtenti() {
		List<User> utenti = new ArrayList<>();
		Connection connection=null;
		Statement statement = null;
		ResultSet risultato = null;
		try {
			connection= db.getConnection();
			statement = connection.createStatement();

			risultato = statement.executeQuery(VISUALIZZA_UTENTI);
			while (risultato.next()) {
				int id = risultato.getInt("id");
				String name = risultato.getString("name");
				String email = risultato.getString("email");
				int age = risultato.getInt("age");
				String dateOfBirth = risultato.getString("dateOfBirth");
				String country = risultato.getString("country");
				User utente = new User();
				utente.setId(id);
				utente.setName(name);
				utente.setEmail(email);
				utente.setAge(age);
				utente.setDateOfBirth(dateOfBirth);
				utente.setCountry(country);
				utenti.add(utente);

			}

		} catch (SQLException e) {
			errorMessage(e);
		}
		finally{
			try {
				risultato.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				
				errorMessage(e);
			}
		}
		return utenti;
	}

	public void cancellaUtente(int id) {
		Connection connection=null;
		PreparedStatement statement = null;
		try {
			connection= db.getConnection();
			statement= connection.prepareStatement(CANCELLA_UTENTE_ID);
			statement.setInt(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("L'utente è stato cancellato dal DB");
			}
			
		} catch (SQLException e) {
		
			errorMessage(e);
		}
		finally{
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				errorMessage(e);
			}
		}

}
	  public void errorMessage (SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	
}