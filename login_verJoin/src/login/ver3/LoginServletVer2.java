package login.ver3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.ver3.model.MemberList;


//@WebServlet("/login.ver2")
public class LoginServletVer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer=response.getWriter();
		writer.print("<h1><a href=\""+request.getHeader("referer")+"\">���������� ���ư���</a></h1>");
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().println("<br/>"+getServletConfig().getInitParameter("adminEmail"));
//		response.getWriter().println("<br/>"+getServletConfig().getInitParameter("mainEmail"));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		MemberList memberList=new MemberList();
		String[] result=memberList.checkMember(id, pwd);

		request.setAttribute("result", result);
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
	}

}
