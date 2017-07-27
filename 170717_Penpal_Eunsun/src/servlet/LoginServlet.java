package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("check");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		System.out.println(id+" : "+pwd);
		
		String name="사용자";
		
		if(id.equals("admin")&&pwd.equals("1234")){
			name="관리자";
		} else if(id.equals("lecto")&&pwd.equals("1234")){
			name="렉토피아";
		}
		System.out.println("로그인정보확인 "+name);
		
		HttpSession session = request.getSession(false);
		if(session==null){
			session = request.getSession();
			
		}
		session.setAttribute("name", name);
		//System.out.println("세션이름"+session.getAttribute("name"));
		
		//request.setAttribute("name", name);
		RequestDispatcher view1 = request.getRequestDispatcher("loginCheck_do");
		//RequestDispatcher view1 = request.getRequestDispatcher("login.jsp");
		view1.forward(request, response);
	}

}
