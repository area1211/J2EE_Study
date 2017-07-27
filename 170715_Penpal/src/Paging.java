

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Paging
 */
public class Paging extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int spage = 1;
		//String page = request.getParameter("page");
		/*
		if(page!=null){
			spage = Integer.parseInt(page);
		}
		*/
		
		
		ArrayList<TestBean> list = new ArrayList<TestBean>();
		list.add(new TestBean("nani1", 26));
		list.add(new TestBean("nani2", 27));
		list.add(new TestBean("nani3", 28));
		list.add(new TestBean("nani4", 29));
		list.add(new TestBean("nani5", 30));
		int listCount = 5;
		
		int maxPage = (int)(listCount/2.0+0.5);
		int startPage = (int)(spage/5.0+0.8)*5-4;
		int endPage = startPage+4;
		if(endPage > maxPage) endPage = maxPage;
		
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("paging.jsp");
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
