package com.lecto.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class BeerRequestFilter implements Filter{
	private FilterConfig fc;
	
	public void init(FilterConfig config) throws ServletException {
		this.fc=config;
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
		throws ServletException, IOException {
		HttpServletRequest httpReq = (HttpServletRequest)req; // down Ä³½ºÆÃ
		String name = httpReq.getRemoteUser();
		if(name!=null){
			fc.getServletContext().log("User " + name + " is updating.");
		}
		
		chain.doFilter(req,  resp);
	}
	
	public void destroy(){
		
	}
}
