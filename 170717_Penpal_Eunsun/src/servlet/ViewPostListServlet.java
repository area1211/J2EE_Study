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
		list.add(new PostVO(923,"����","�����̴�","�����̴�~~","2017/07/05/12:05",0));
		list.add(new PostVO(933,"����1","�����̴�","�����̴�~~","2017/07/05/12:05",0));
		list.add(new PostVO(941,"����2","�����̴�","�����̴�~~","2017/07/05/12:05",0));
		list.add(new PostVO(922,"����3","�����̴�","�����̴�~~","2017/07/05/12:05",0));
		for(int i= 0; i<121;i++){
			list.add(new PostVO(i,"�ǿ�" +i,"�����̴�","�����̴�~~","2017/07/05/12:05",0));
		}
		
		int listNum = 10; // �⺻ �Խñ� ��� ����
		String lNum = request.getParameter("lNum");
		if(lNum != null){
			listNum = Integer.parseInt(lNum);
		}
		request.setAttribute("lNum", listNum);

		// ��ü �� ��
		int listCount = list.size();
		
		// ���� ������ ��ȣ �����
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
		
		//�Խñ� ��� ���� ��ŭ �Խñ� ��������
//		int fromIndex = (maxPage-spage+1)*listNum-listNum + 1;
//		int toIndex =(maxPage-spage+1)*listNum+listNum-10;
//		if(toIndex>=listCount)
//			toIndex=listCount;
//		System.out.println("��ü�ۼ� : "+listCount);
//		System.out.println("������������ȣ : "+spage);
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
