

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReceiveFriendListServ
 */
public class ReceiveFriendListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<String[]> list = new ArrayList<String[]>();
			list.add(new String[]{"1","2","3","4","5","images/human.JPG","0","2017/07/16"});
			list.add(new String[]{"1","2","3","4","5","videos/�ǳ�.mp4","1","2017/07/16"});
			list.add(new String[]{"1","2","3","4","5","videos/�ǳ�.mp4","1","2017/07/16"});
			request.setAttribute("list", list);
			RequestDispatcher view = request.getRequestDispatcher("receivefriend_list.jsp");
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
