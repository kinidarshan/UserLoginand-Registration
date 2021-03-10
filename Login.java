package com.fujitsu.loginandRegister.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
	
	System.out.println("start of dopost");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	
	Login  dao = new Login();
	boolean result = dao.verifyUserCredentials(username, password);
	
	if(result) {
		System.out.println("Executing if block"+result);
	
	
	
		HttpSession session = request.getSession();
	    session.setAttribute(username, session);
	    response.sendRedirect("welcome.jsp");
	    System.out.println("redirect the response to welcome page"+ result);
	
	}
	else {
	  response.sendRedirect("loginjsp");
	
}
	System.out.println("end  of dopost");
	}

	private boolean verifyUserCredentials(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}