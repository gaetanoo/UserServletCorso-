package com.corso.servlet;

import java.io.IOException;

import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corso.model.User;
import com.corso.service.UserServiceImpl;
import com.corso.service.ValidationUserException;

/**
 * Servlet implementation class UpdateUserServerlet
 */
@WebServlet("/edit")
public class ReadUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServiceImpl userv= new UserServiceImpl();

   
    public ReadUserServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp"); //dispatcher richiede una risorsa
		
		try {
			readUser(request);
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//response.sendRedirect("list");
		dispatcher.forward(request, response);
		
	}

	  private void readUser(HttpServletRequest request)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
					User user =userv.getUser(id);
			        request.setAttribute("user", user);
      }
}