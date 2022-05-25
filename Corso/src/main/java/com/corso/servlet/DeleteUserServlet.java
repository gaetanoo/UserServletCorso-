package com.corso.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.corso.service.UserServiceImpl;


@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServiceImpl userv= new UserServiceImpl();
  
    public DeleteUserServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		int id= Integer.parseInt(request.getParameter("id"));
		userv.cancellaUtente(id);
		response.sendRedirect("list");
	}




}
