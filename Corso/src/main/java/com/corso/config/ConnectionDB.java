package com.corso.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionDB {
	
//	private String dbURL = "jdbc:mysql://localhost:3306/Corso?useSSL=false";
//	private String username = "root";
//	private String password = "beside";
		

		public Connection getConnection() {
			Connection connection = null;
			Context context = null;
			
			try {
				context = new InitialContext();
				DataSource ds = (DataSource) context.lookup("java:/comp/env/corso"); 
				connection= ds.getConnection();
		
				if (connection != null) {			
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
			
				e.printStackTrace();
			}
			return connection;
		}  
		
}

