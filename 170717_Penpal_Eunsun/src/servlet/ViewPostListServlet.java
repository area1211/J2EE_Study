package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.PostVO;

public class ViewPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		List<PostVO> list = new ArrayList<PostVO>();
		list.add(new PostVO(923,"은선","제목이다","내용이다~~","2017/07/05/12:05",0));
		list.add(new PostVO(933,"은선1","제목이다","내용이다~~","2017/07/05/12:05",0));
		list.add(new PostVO(941,"은선2","제목이다","내용이다~~","2017/07/05/12:05",0));
		list.add(new PostVO(922,"은선3","제목이다","내용이다~~","2017/07/05/12:05",0));
		for(int i= 0; i<121;i++){
			list.add(new PostVO(i,"의연" +i,"제목이다","내용이다~~","2017/07/05/12:05",0));
		}
		
		int listNum = 10; // 기본 게시글 목록 개수
		String lNum = request.getParameter("lNum");
		if(lNum != null){
			listNum = Integer.parseInt(lNum);
		}
		request.setAttribute("lNum", listNum);

		// 전체 글 수
		int listCount = list.size();
		
		// 현재 페이지 번호 만들기
		int spage = 1;
		String page = request.getParameter("page");
		if(page != null)
			spage = Integer.parseInt(page);
		
		int maxPage = (int)((double)listCount/listNum + 1 - (double)1/listNum);
		int startPage = (int)(spage/5.0 + 0.8)*5 - 4;
		int endPage = startPage + 4;
		if(endPage > maxPage) endPage = maxPage;
		
		
		System.out.println("spage:"+spage+", maxPage:"+maxPage+", startPage:"+startPage+", endPage:"+endPage);
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		//게시글 목록 개수 만큼 게시글 가져오기
//		int fromIndex = (maxPage-spage+1)*listNum-listNum + 1;
//		int toIndex =(maxPage-spage+1)*listNum+listNum-10;
//		if(toIndex>=listCount)
//			toIndex=listCount;
//		System.out.println("전체글수 : "+listCount);
//		System.out.println("현제페이지번호 : "+spage);
		int toIndex = listCount - (spage-1)*listNum;
		int fromIndex = toIndex - listNum;
		if(fromIndex <= 0)
			fromIndex = 0;
		
//		List<PostThumbBean> subList = blc.changeBoard(1, fromIndex, toIndex);

		
		
//		request.setAttribute("p_list", subList);
		
		System.out.println("from:"+fromIndex+", to:"+toIndex);
		list=list.subList(fromIndex, toIndex);
		request.setAttribute("list", list);
		RequestDispatcher rq = request.getRequestDispatcher("view_postlist.jsp");
		rq.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
