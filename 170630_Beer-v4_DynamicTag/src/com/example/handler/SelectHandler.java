package com.example.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectHandler extends SimpleTagSupport implements DynamicAttributes{
	private List<String> optionsList;
	private String name;
	private int size;
	
	private static final String ATTR_TEMPLATE = "%s='%s'";
	private static final String OPTION_TEMPLATE = "<option value='%1$s'>%1$s</option>";
	public void doTag(){
		PageContext pageContext = (PageContext)getJspContext();
		JspWriter out = pageContext.getOut();
		
		try {
//			out.println("<select name=\'"+name+"\' size=\'"+size+"\' >");
//			for(String option:optionsList){
//				out.println("<option value=\'"+option+"\'>"+option+"</option>");
//			}
//			out.println("</select>");
			out.print("<select ");
			out.print(String.format(ATTR_TEMPLATE, "name", this.name));
			out.print(String.format(ATTR_TEMPLATE, "size", Integer.valueOf(this.size).toString()));
			for(String attrName: tagAttrs.keySet()){
				String attrDefinition = String.format(ATTR_TEMPLATE, attrName, tagAttrs.get(attrName));
				out.print(attrDefinition);
			}
			out.print(">");
			
			for(String option: optionsList){
				String optionTag=String.format(OPTION_TEMPLATE, option.toString());
				out.print(optionTag);
			}
			out.print("</select>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getOptionsList() {
		return optionsList;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public void setOptionsList(List<String> optionsList) {
		this.optionsList = optionsList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(int size) {
		this.size = size;
	}
	private Map<String, Object> tagAttrs = new HashMap<String, Object>();
	public void setDynamicAttribute(String uri, String name, Object value){
		tagAttrs.put(name, value);
	}
}
