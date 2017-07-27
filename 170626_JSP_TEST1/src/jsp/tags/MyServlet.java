package jsp.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.tags.bean.Dog;
import jsp.tags.bean.Person;
import jsp.tags.bean.Toy;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Toy[] toys = new Toy[]{ new Toy("부메랑"), new Toy("막대기"), new Toy("인형") };
		Person person = new Person("홍길동", new Dog("바둑이", toys));
		request.setAttribute("person", person);
		
		List<String> snacks = new ArrayList<String>();
		snacks.add("아이스크림"); snacks.add("피자"); snacks.add("팝콘"); snacks.add("초콜렛");
		request.setAttribute("foods", snacks);
		
		Map<String, String> musics = new HashMap<String, String>();
		musics.put("C1", "가요"); musics.put("C2", "팝"); musics.put("C3", "클래식"); musics.put("C4", "CCM");
		request.setAttribute("music", musics);
		request.setAttribute("C4", "C3");
		
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
