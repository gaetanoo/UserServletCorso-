package com.corso.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corso.model.User;
import com.corso.service.UserServiceImpl;


@WebServlet("/list")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl userv;
	
    public void init() {
    	userv= new UserServiceImpl();
    }
   
    public ListUserServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		// Definisce un oggetto che riceve richieste dal client e le manda alla servlet spec.
		//La servlet prende la request dalla pag
		//dispatcher porta request in response
			try {
				listUser(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ServletException e) {
				
				e.printStackTrace();
			}
			dispatcher.forward(request, response);
			//passo la request per creare la risposta da inviare alle pagine
	
	}
	
	 private void listUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < User > listUser = userv.visualizzaUtenti();
			        request.setAttribute("listUser", listUser);
			        //con java assegno la lista listUser come attributo della richiesta
			       
			    
			    }
	 


}
