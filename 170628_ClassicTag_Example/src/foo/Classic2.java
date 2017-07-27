package foo;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Classic2 extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JspWriter out;
	
	public int doStartTag() throws JspException {
		out = pageContext.getOut();
		try {
			out.println("in doStartTag()");
		} catch(IOException ex){
			throw new JspException("IOException- " + ex.toString());
		}
		
		return SKIP_BODY;
	}
	
	public int doEndTag() throws JspException {
		try{
			out.println("in doEndTag()");
		} catch(IOException ex){
			throw new JspException("IOException- " + ex.toString());
		}
		return EVAL_PAGE;
	}
}
