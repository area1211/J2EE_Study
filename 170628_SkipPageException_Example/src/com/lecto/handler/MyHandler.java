package com.lecto.handler;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyHandler extends SimpleTagSupport {
	private String name;
	public void doTag() throws JspException, IOException{
		getJspContext().getOut().print("doTag()1. Message from within doTag().<br>");	
		getJspContext().getOut().print("doTag()2. About to throw a SkipPageException");
		if(name==null){
			throw new SkipPageException();
		}
	}
	
	public void setName(String name){
		this.name=name;
	}
}
