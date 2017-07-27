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
		
		
		int listNum = 10; // 기본 게시글 목록 개수
		String lNum = request.getParameter("lNum");
		if(lNum != null){
			listNum = Integer.parseInt(lNum);
		}
		request.setAttribute("lNum", listNum);
		//테스트 게시글 만들기
//		int listCount = 118;
//		List<PostBean> list = new ArrayList<PostBean>();
//		for(int i=0; i<listCount; i++){
//			list.add(new PostBean(Integer.toString(i), "테스트제목"+i, "정인호", "17.07.03", "알랑숑뱡숑용", 10, 0));
//		}
		int listCount = mbd.getPostListSize();
		
		
		// 현재 페이지 번호 만들기
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
		
		//게시글 목록 개수 만큼 게시글 가져오기
		int fromIndex = spage*listNum-listNum + 1;
		int toIndex = spage*listNum+listNum-10;
		
		if(toIndex>=listCount)
			toIndex=listCount;
		
		List<PostVo> subList = mbd.getPostList(1, fromIndex, toIndex);
		//List<PostBean> subList = list.subList(spage*listNum-listNum, toIndex);
		
		
		String board="축구게시판";
		String intro="자유롭게 축구 관련 이야기를 나눌 수 있는 게시판입니다";
		
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
