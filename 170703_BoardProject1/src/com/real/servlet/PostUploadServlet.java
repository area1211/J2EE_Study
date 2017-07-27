package com.real.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.real.command.PostUploadCommand;

/**
 * Servlet implementation class PostUploadServlet
 */
public class PostUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		Date date = new Date();
//		String p_date = format.format(date);
//		String nickname = (String)session.getAttribute("nickname");
//		String title = request.getParameter("p_title");
//		String body = request.getParameter("p_body");
//	
//		
//		
//		System.out.println(nickname);
//		System.out.println(title+"\n"+body);
//		System.out.println(p_date);
//		
//		PostUploadCommand puc = new PostUploadCommand();
//		puc.add(title, body, p_date, nickname, true);
//
//		RequestDispatcher view = request.getRequestDispatcher("Front.do?cmd=BoardList");
//		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String p_date = format.format(date);
		String nickname = (String)session.getAttribute("nickname");
		String title = request.getParameter("p_title");
		String body = request.getParameter("p_body");
	
		
		
		System.out.println(nickname);
		System.out.println(title+"\n"+body);
		System.out.println(p_date);
		
		PostUploadCommand puc = new PostUploadCommand();
		puc.add(title, body, p_date, nickname, true);

//		RequestDispatcher view = request.getRequestDispatcher("Front.do?cmd=BoardList");
//		view.forward(request, response);
		
		response.sendRedirect("Front.do?cmd=BoardList");
	}

}
