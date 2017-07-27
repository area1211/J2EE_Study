package com.lecto.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lecto.model.ShoppingCart;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String product = request.getParameter("p_name");
		
		HttpSession session = request.getSession(false);
		if(session == null){
			ShoppingCart cart = new ShoppingCart();
			session = request.getSession();
			session.setAttribute("cart", cart);
		}
		
		ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
		cart.add(product);
		
		
//	
//		ServletContext sc = this.getServletContext();
//		ShoppingCart cart = (ShoppingCart)sc.getAttribute("cart");
//		
		
		String[] p_list = null;
		Iterator<String> itr= null;
		synchronized (cart){
			cart.add(product);
			p_list = new String[cart.getList().size()];
			itr = cart.getList().iterator();
		}
		
		int i=0;
		while(itr.hasNext()){
			p_list[i++]=(String)itr.next();
		}
		request.setAttribute("cart", p_list);
		
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		
		view.forward(request, response);
		
	}

}
