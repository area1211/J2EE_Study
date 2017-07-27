package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckLoginServlet
 */
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String name=(String)session.getAttribute("name");
		System.out.println(name);
		
		RequestDispatcher view1=null;
		if(session!=null){ //세션있음
			if(name.equals("관리자")){
				session.setAttribute("isAdmin", true);
				System.out.println("check");
				//view1 = request.getRequestDispatcher("loginTest.jsp");
			}
			else{
				session.setAttribute("isAdmin", false);
				//view1 = request.getRequestDispatcher("loginTest.jsp");
			}
			session.setAttribute("isLogin", true);
		}
		/*else{ //세션없음(로그인전)
			session.setAttribute("isLogin", false);
			//view1 = request.getRequestDispatcher("loginTest.jsp");
		}*/
		view1 = request.getRequestDispatcher("login.jsp");
		view1.forward(request, response);
		return;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}