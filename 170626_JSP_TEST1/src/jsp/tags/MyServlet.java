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
		Toy[] toys = new Toy[]{ new Toy("�θ޶�"), new Toy("�����"), new Toy("����") };
		Person person = new Person("ȫ�浿", new Dog("�ٵ���", toys));
		request.setAttribute("person", person);
		
		List<String> snacks = new ArrayList<String>();
		snacks.add("���̽�ũ��"); snacks.add("����"); snacks.add("����"); snacks.add("���ݷ�");
		request.setAttribute("foods", snacks);
		
		Map<String, String> musics = new HashMap<String, String>();
		musics.put("C1", "����"); musics.put("C2", "��"); musics.put("C3", "Ŭ����"); musics.put("C4", "CCM");
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
