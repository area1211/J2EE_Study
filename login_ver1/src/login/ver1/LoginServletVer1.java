package login.ver1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login.ver1")
public class LoginServletVer1 extends HttpServlet {
	// 통신할 때 직렬화 하기 때문에 serialVersionUID가 필요하다.
	private static final long serialVersionUID = 1L; 
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			// 내부적으로 throws 하고 있는데 WAS 내부의 TOMCAT 디버깅 모드에서 처리하고 있는 것이다.
			throws ServletException, IOException { 
		// 몇 바이트 단위로 해석할지 지정해주는 것이다. 여기서는 UTF-8 방식을 지정했다.
		request.setCharacterEncoding("UTF-8"); 
		// getParameter()는 데이터 형태로 전송된 애들 꺼내는 메소드이다. 
		// 파라미터로 태그 이름(name)을 넣어준다.
		// 앞서 index.html 에서 아이디와 패스워드 입력하는 input 태그에서 name을 각각 "id", "pwd"로 줬기 때문에 해당 이름을 쓴다.
		String id = request.getParameter("id"); 
		String pwd = request.getParameter("pwd");
		// 브라우져가 전송한 요청객체(request Header)에서 데이터( id, pwd )꺼낸 것이다. 
		// get 방식은 url에서, post는 압축된 데이터에서 꺼낸다. default는 get전송방식이다.
 		// 원칙적으로 유효성검증하기위해 다시 db 단으로 가야할 것이다.
		/*--------------------------여기까지 데이트 전송 받는 부분---------------------------------- */
		
		// 브라우져 쪽으로 내보낼 스트림에 대고 타입을 UTF-8으로 해석하라고 헤더에 달아서 보내주는 것이다. 
		// 전송시킬때 암호화 시키되 브라우져한테 해석방법을 알려주는 것이다.
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter writer = response.getWriter();
		// 태그 없이 그냥 문자열이면 body 태그 안으로 집어넣는다.
		// <br/> 은HTML Parser 입장에서  라인내리는 태그준것.
		writer.println("id: " + id +"<br/>pwd: "+pwd); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { // 내부적으로 throws 하고 있는데 WAS 내부의 TOMCAT 디버깅 모드에서 처리하고 있는 것이다.
		doGet(request, response); // doGet 에 위임하는 방식
	}

}
