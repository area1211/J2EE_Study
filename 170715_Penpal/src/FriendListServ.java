

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FriendListServ
 */
public class FriendListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String[]> list = new ArrayList<String[]>();
		list.add(new String[]{"1","2","3","4","5","images/human.JPG","0","한국어","2017/07/16","20회"});
		list.add(new String[]{"1","2","3","4","5","videos/악녀.mp4","1","영어,일본어","2017/07/16","30회"});
		list.add(new String[]{"1","2","3","4","5","videos/악녀.mp4","1","스페인어,불어","2017/07/16","40회"});
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("friend_list.jsp");
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
