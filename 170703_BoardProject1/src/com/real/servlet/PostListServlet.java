package com.real.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lecto.model.PostThumbBean;
import com.real.command.BoardListCommand;

/**
 * Servlet implementation class PostListServlet
 * BoardListAction.do
 */
public class PostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BoardListCommand blc = new BoardListCommand();
		
		int listNum = 10; // 기본 게시글 목록 개수
		String lNum = request.getParameter("lNum");
		System.out.println(lNum+"개를 뿌리게씁니다아.");
		if(lNum != null){
			listNum = Integer.parseInt(lNum);
		}
		request.setAttribute("lNum", listNum);

		// 전체 글 수
		int listCount = blc.getPostListSize();
		
		
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
		int fromIndex = (maxPage-spage+1)*listNum-listNum + 1;
		int toIndex =(maxPage-spage+1)*listNum+listNum-10;
//		if(toIndex>=listCount)
//			toIndex=listCount;
//		System.out.println("전체글수 : "+listCount);
//		System.out.println("현제페이지번호 : "+spage);
//		int toIndex = listCount - (spage-1)*listNum;
//		int fromIndex = toIndex - listNum + 1;
//		if(fromIndex <= 0)
//			fromIndex = 1;
		
		List<PostThumbBean> subList = blc.changeBoard(1, fromIndex, toIndex);

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
