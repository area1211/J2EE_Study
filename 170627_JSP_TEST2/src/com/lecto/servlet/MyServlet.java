package com.lecto.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
		// TODO Auto-generated method stub
		List<String[]> movies1 = new ArrayList<String[]>();
		movies1.add(new String[]{"터미네이터", "스타트랙", "매트릭스"});
		movies1.add(new String[]{"곰돌이 푸우", "스누피", "가필드"});
		
		Map<String, String[]> movies2 = new TreeMap<String, String[]>();
		movies2.put("SF", movies1.get(0));
		movies2.put("ANIMATION", movies1.get(1));
		
		String movies3 = "SF:SF영화,ANIMATION:애니메이션";
		
		request.setAttribute("movies", movies1);
		request.setAttribute("moviesMap", movies2);
		request.setAttribute("movieKinds", movies3);
		
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
