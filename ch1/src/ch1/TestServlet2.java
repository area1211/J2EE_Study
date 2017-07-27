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
// 변수명 = 값 인데 name은 식별자라서 여러개 오지 않아서 중괄호 없다
// url 맵핑은 여러개 올수도있다. ex) post, get 방식에 있어서 다른 맵핑주소를 다르게 줄 수 있다.
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath()); // test 코드
		PrintWriter out = response.getWriter();
		java.util.Date today = new java.util.Date();
		out.println("<h1 align=center>HF\'s Capter 1 Servlet</h1>" + "<br/>" + today );
	}

}
