package com.lecto.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lecto.model.PostThumbBean;

/**
 * Servlet implementation class PostServlet
 */
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<PostThumbBean> list = new ArrayList<PostThumbBean>();
		for(int i=0; i<10; i++){
			//list.add(new PostThumbBean(Integer.toString(i), "Å×½ºÆ®Á¦¸ñ"+i, "Á¤ÀÎÈ£", "17.07.03", "¾Ë¶û¼õ“‡¼õ¿ë", 10, 0));
		}
		
		int pageNum = Integer.parseInt(request.getParameter("num"));
		request.setCharacterEncoding("utf-8");
		request.setAttribute("detail", list.get(pageNum));
		
		RequestDispatcher view = request.getRequestDispatcher("post.jsp");
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
