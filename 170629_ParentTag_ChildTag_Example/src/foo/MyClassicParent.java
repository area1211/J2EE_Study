package foo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyClassicParent extends TagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;
	}
}
