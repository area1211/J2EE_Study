package ch1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet2
 */
//@WebServlet(name = "TestServletRef", urlPatterns = { "/test" }) 
// ������ = �� �ε� name�� �ĺ��ڶ� ������ ���� �ʾƼ� �߰�ȣ ����
// url ������ ������ �ü����ִ�. ex) post, get ��Ŀ� �־ �ٸ� �����ּҸ� �ٸ��� �� �� �ִ�.
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath()); // test �ڵ�
		PrintWriter out = response.getWriter();
		java.util.Date today = new java.util.Date();
		out.println("<h1 align=center>HF\'s Capter 1 Servlet</h1>" + "<br/>" + today );
	}

}
