package com.lecto.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lecto.model.EmployeesDAO;
import com.lecto.model.EmployeesVO;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// firstName, lastName�� Ȯ���Ѵ�.
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		EmployeesVO result = ((EmployeesDAO)request.getServletContext().getAttribute("DAO")).search(firstName, lastName);
		// request�� ����Ѵ�.
		request.setAttribute("result", result);
		// jsp�� �����Ѵ�.
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
