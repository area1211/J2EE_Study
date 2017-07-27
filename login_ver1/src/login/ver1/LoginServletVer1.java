package login.ver1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login.ver1")
public class LoginServletVer1 extends HttpServlet {
	// ����� �� ����ȭ �ϱ� ������ serialVersionUID�� �ʿ��ϴ�.
	private static final long serialVersionUID = 1L; 
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			// ���������� throws �ϰ� �ִµ� WAS ������ TOMCAT ����� ��忡�� ó���ϰ� �ִ� ���̴�.
			throws ServletException, IOException { 
		// �� ����Ʈ ������ �ؼ����� �������ִ� ���̴�. ���⼭�� UTF-8 ����� �����ߴ�.
		request.setCharacterEncoding("UTF-8"); 
		// getParameter()�� ������ ���·� ���۵� �ֵ� ������ �޼ҵ��̴�. 
		// �Ķ���ͷ� �±� �̸�(name)�� �־��ش�.
		// �ռ� index.html ���� ���̵�� �н����� �Է��ϴ� input �±׿��� name�� ���� "id", "pwd"�� ��� ������ �ش� �̸��� ����.
		String id = request.getParameter("id"); 
		String pwd = request.getParameter("pwd");
		// �������� ������ ��û��ü(request Header)���� ������( id, pwd )���� ���̴�. 
		// get ����� url����, post�� ����� �����Ϳ��� ������. default�� get���۹���̴�.
 		// ��Ģ������ ��ȿ�������ϱ����� �ٽ� db ������ ������ ���̴�.
		/*--------------------------������� ����Ʈ ���� �޴� �κ�---------------------------------- */
		
		// ������ ������ ������ ��Ʈ���� ��� Ÿ���� UTF-8���� �ؼ��϶�� ����� �޾Ƽ� �����ִ� ���̴�. 
		// ���۽�ų�� ��ȣȭ ��Ű�� ���������� �ؼ������ �˷��ִ� ���̴�.
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter writer = response.getWriter();
		// �±� ���� �׳� ���ڿ��̸� body �±� ������ ����ִ´�.
		// <br/> ��HTML Parser ���忡��  ���γ����� �±��ذ�.
		writer.println("id: " + id +"<br/>pwd: "+pwd); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { // ���������� throws �ϰ� �ִµ� WAS ������ TOMCAT ����� ��忡�� ó���ϰ� �ִ� ���̴�.
		doGet(request, response); // doGet �� �����ϴ� ���
	}

}
