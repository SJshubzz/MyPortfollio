package com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.deleteDaoImpl;
public class DeleteMessage extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sn = request.getParameter("sn");
		HttpSession session = request.getSession();
//Dao
		String res = new deleteDaoImpl().deleteMessage(sn);
		if (res.equals("deleted")) {
			session.setAttribute("msg", "Message deleted sucssesfully..");
			response.sendRedirect("read-message.jsp");
			
		}
		else {
			session.setAttribute("msg", "Something went wrong..");
			response.sendRedirect("read-message.jsp");
		}
	}

}
