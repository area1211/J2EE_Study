

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileSearch
 */
public class ProfileSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		       
		  
		      request.setCharacterEncoding("UTF-8");
		      response.setContentType("text/html;charset=UTF-8");
		      List<String> temp = new ArrayList<String>();
		      temp.add("남성");
		      temp.add("여성");
		      request.setAttribute("sexList", temp);
		      List<Integer> ageList = new ArrayList<Integer>();
		      for(int i = 1; i<=120; i++){
		         ageList.add(i);
		      }
		      request.setAttribute("ageList",  ageList);
		      List<String> countryList = new ArrayList<String>();
		      countryList.add("대한민국");
		      countryList.add("미국");
		      request.setAttribute("countryList",  countryList);
		      RequestDispatcher rd = request.getRequestDispatcher("profile_search.jsp");
		      rd.forward(request, response);
		   


		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
