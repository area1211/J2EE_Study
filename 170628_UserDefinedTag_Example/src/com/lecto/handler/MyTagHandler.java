package com.lecto.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.lecto.bean.MovieBean;

public class MyTagHandler extends SimpleTagSupport{
	String[] movies;
	String[] colors;
	private List<MovieBean> movieList;
	
	public void doTag() throws JspException, IOException {
//		movies=new String[]{"Monsoon Wedding", "Saved!", "Fahrenheit 9/11"};
//		for(String tmp: movies){
//			getJspContext().setAttribute("movie", tmp);
//			getJspBody().invoke(null);
//		}
		
		for(MovieBean tmp: movieList){
			getJspContext().setAttribute("movie", tmp);
			getJspBody().invoke(null);
		}
	}
	
	public void setColors(String[] colors){
		this.colors=colors;
	}
	public void setMovieList(List<MovieBean> movieList){
		this.movieList=movieList;
	}
}
