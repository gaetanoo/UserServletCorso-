package com.corso.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corso.service.UserServiceImpl;
import com.corso.service.ValidationUserException;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServiceImpl userv = new UserServiceImpl();
	
    public UpdateUserServlet() {
        super();
        
    }




	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		int id= Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String dateOfBirth = request.getParameter("dateOfBirth");
        String country = request.getParameter("country");
		try {
			userv.modificaUtente(id, name, email, age, dateOfBirth, country);
		} catch (ValidationUserException e) {
			
			e.printStackTrace();
		}
		
		response.sendRedirect("list");
	}

}
