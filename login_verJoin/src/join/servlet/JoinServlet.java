package join.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.ver3.model.MemberList;

/**
 * Servlet implementation class JoinServlet
 */
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("m_mail");
		String pwd=request.getParameter("m_pass");
		String name=request.getParameter("m_name");
		
		MemberList memList = new MemberList();
		memList.add(id, name, pwd);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		//out.println(id+", "+name+", "+pwd+"가 성공적으로 추가되었습니다.");
		System.out.println(id+", "+name+", "+pwd+"가 성공적으로 추가되었습니다.");
		response.sendRedirect("http://localhost:8080/login_verJoin/index.html");
	}

}
