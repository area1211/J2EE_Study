package com.real.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontServlet
 */
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view=null;
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		if(cmd == null)
			cmd = "BoardList";
		switch(cmd){ // java 7 버전 이후 부터 switch 문의 조건식?에 문자열 사용이 가능하다.
		case "BoardList" :
			view = request.getRequestDispatcher("BoardListAction.do");
			view.forward(request, response);
			//response.sendRedirect("BoardListAction.do");
			break;
		case "Login.do" :
			view = request.getRequestDispatcher("Login.do");
			view.forward(request, response);
			break;
		case "Logout.do" :
			view = request.getRequestDispatcher("Logout.do");
			view.forward(request, response);
			break;	
		case "WriteForward.do" :
			view = request.getRequestDispatcher("write.jsp");
			view.forward(request, response);
			break;
		case "PostUpload.do" :
			view = request.getRequestDispatcher("PostUpload.do");
			view.forward(request, response);
			break;
		case "PostDetail.do" :
			view = request.getRequestDispatcher("PostDetail.do");
			view.forward(request, response);
			break;
		case "PostDelete.do" :
			view = request.getRequestDispatcher("PostDelete.do");
			view.forward(request, response);
		default:
				//없는요청
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
