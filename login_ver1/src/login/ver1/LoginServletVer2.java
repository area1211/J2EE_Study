package login.ver1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login.ver2")
public class LoginServletVer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer=response.getWriter();
		writer.println("아이디:"+id+"<input type=\"button\" value=\"버트은\"/><br/><br/> 비밀번호:"+pwd);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
