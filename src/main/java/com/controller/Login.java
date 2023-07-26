package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MessaegeDao;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
//		Dao
		String res = new MessaegeDao().login(email, password);
		HttpSession session=request.getSession();
		if (res.equals("exist")) {
			session.setAttribute("check", email);
			response.sendRedirect("read-message.jsp");
		}
		else {
			session.setAttribute("msg", "Email or Password incorrect.");
			response.sendRedirect("login.jsp"); 
		}
	}

}
