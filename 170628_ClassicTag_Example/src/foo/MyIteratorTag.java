package foo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyIteratorTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int count;
	String[] movies = {"Spiderman", "Saved!", "Amelie"};
	public int doStartTag() throws JspException {
		count=0;
		
		pageContext.setAttribute("movie", movies[count++]);
		return EVAL_BODY_INCLUDE;
	}
	
	public int doAfterBody() throws JspException {
		
		if(count<movies.length){
			pageContext.setAttribute("movie", movies[count++]);
			return EVAL_BODY_AGAIN;
		}
		
		return SKIP_BODY;
	}
	
	public int doEndTag() throws JspException {
		
		
		return EVAL_PAGE;
	}
}
