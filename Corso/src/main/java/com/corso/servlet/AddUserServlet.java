package com.corso.servlet;

import java.io.IOException;
import java.sql.Date;

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
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServiceImpl userv= new UserServiceImpl();
	
 
    public AddUserServlet() {
        super();
       
    }


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
		String name = request.getParameter("name");
		if(name==null || name == "") {
			request.setAttribute("errorName", "Campo nome nullo");
		}
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String dateOfBirth = request.getParameter("dateOfBirth");
        String country = request.getParameter("country");
        

        	try {
				userv.creaUtente(name, email, age, dateOfBirth, country);
			} catch (ValidationUserException e) {
				
				e.printStackTrace();
			}
          //  response.sendRedirect("list");
            dispatcher.forward(request, response);
    }
		// doGet(request, response);
	}


