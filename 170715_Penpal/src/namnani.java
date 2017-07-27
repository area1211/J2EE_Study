

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class namnani
 */
public class namnani extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public namnani() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("num")!= null){
		if(request.getParameter("num").equals("1")){
			int spage=1;
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
			
			else if(request.getParameter("num").equals("2")){
				int spage = 2;
				
				ArrayList<TestBean> list = new ArrayList<TestBean>();
				list.add(new TestBean("nani6", 6));
				list.add(new TestBean("nani7", 7));
				list.add(new TestBean("nani8", 8));
				list.add(new TestBean("nani9", 9));
				list.add(new TestBean("nani10", 10));
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
		
			else if(request.getParameter("num").equals("3")){
				int spage = 3;
				
				ArrayList<TestBean> list = new ArrayList<TestBean>();
				list.add(new TestBean("nani123", 123));
				list.add(new TestBean("nani123", 123));
				list.add(new TestBean("nani123", 123));
				list.add(new TestBean("nani123", 123));
				list.add(new TestBean("nani123", 123));
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
		}
		
//		if(request.getParameter("num")!= null){
			   
			}
		/*
		int spage = 2;
		
		ArrayList<TestBean> list = new ArrayList<TestBean>();
		list.add(new TestBean("nani6", 6));
		list.add(new TestBean("nani7", 7));
		list.add(new TestBean("nani8", 8));
		list.add(new TestBean("nani9", 9));
		list.add(new TestBean("nani10", 10));
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
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
