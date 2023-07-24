package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MessaegeDao;
import com.validation.Validation;

public class Message extends HttpServlet {

	private String result;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		HttpSession session = request.getSession();

		result = new Validation().validate(name, email, message);
		if (result.equals("Valid")) {
			ArrayList<Object> arrayList = new ArrayList<>();
			arrayList.add(name);
			arrayList.add(email);
			arrayList.add(message);
			result = new MessaegeDao().insert(arrayList);
			System.out.println(result);
			if (result == "Saved") {
				session.setAttribute("msg", "Message sent sucssesfully...");
				response.sendRedirect("index.jsp");

			} else {
				session.setAttribute("msg", "Something went wrong...");
				response.sendRedirect("inde x.jsp");

			}
		} else {
			session.setAttribute("msg", result);
			response.sendRedirect("index.jsp");
		}
	}

}