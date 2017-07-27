package com.lecto.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lecto.dao.MessageBoardDAO;
import com.lecto.model.PostThumbBean;
import com.lecto.vo.PostVo;

/**
 * Servlet implementation class MyServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		MessageBoardDAO mbd = new MessageBoardDAO();
		System.out.println(mbd.getPostListSize());
		
		
		int listNum = 10; // �⺻ �Խñ� ��� ����
		String lNum = request.getParameter("lNum");
		if(lNum != null){
			listNum = Integer.parseInt(lNum);
		}
		request.setAttribute("lNum", listNum);
		//�׽�Ʈ �Խñ� �����
//		int listCount = 118;
//		List<PostBean> list = new ArrayList<PostBean>();
//		for(int i=0; i<listCount; i++){
//			list.add(new PostBean(Integer.toString(i), "�׽�Ʈ����"+i, "����ȣ", "17.07.03", "�˶���������", 10, 0));
//		}
		int listCount = mbd.getPostListSize();
		
		
		// ���� ������ ��ȣ �����
		int spage = 1;
		String page = request.getParameter("page");
		
		if(page != null)
			spage = Integer.parseInt(page);
		
		int maxPage = (int)((double)listCount/listNum + 1 - (double)1/listNum);
		int startPage = (int)(spage/5.0 + 0.8)*5 - 4;
		int endPage = startPage + 4;
		if(endPage > maxPage) endPage = maxPage;
		
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		//�Խñ� ��� ���� ��ŭ �Խñ� ��������
		int fromIndex = spage*listNum-listNum + 1;
		int toIndex = spage*listNum+listNum-10;
		
		if(toIndex>=listCount)
			toIndex=listCount;
		
		List<PostVo> subList = mbd.getPostList(1, fromIndex, toIndex);
		//List<PostBean> subList = list.subList(spage*listNum-listNum, toIndex);
		
		
		String board="�౸�Խ���";
		String intro="�����Ӱ� �౸ ���� �̾߱⸦ ���� �� �ִ� �Խ����Դϴ�";
		
		String pBoard = request.getParameter("board");
		if(pBoard!=null)
			board=pBoard;
		
		request.setAttribute("mb_name", board);
		request.setAttribute("mb_thumb", intro);
		
		request.setAttribute("p_list", subList);
		
		
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
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
