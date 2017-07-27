package com.lecto.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.lecto.model.ShoppingCart;

public class MyListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent event){
		ServletContext sc = event.getServletContext();
		
		ShoppingCart cart = new ShoppingCart();
		sc.setAttribute("cart", cart);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
