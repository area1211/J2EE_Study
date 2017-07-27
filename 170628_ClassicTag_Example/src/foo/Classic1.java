package foo;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Classic1 extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.println("classic tag output");
		} catch(IOException e){
			throw new JspException("IOException- "+e.toString());
		}
		
		return SKIP_BODY;
	}
	
}
