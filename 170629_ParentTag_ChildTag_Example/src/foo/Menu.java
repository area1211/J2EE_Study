package foo;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Menu extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> items;
	
	public void addMenuItem(String item){
		items.add(item);
	}
	
	public int doStartTag() throws JspException {
		items = new ArrayList<String>();
		
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().println("Menu items are: "+items);
		} catch(Exception ex){
			throw new JspException("Exception: "+ex.toString());
		}
		
		return EVAL_PAGE;
	}
	
}
