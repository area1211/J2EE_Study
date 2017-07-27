package com.lecto.model;

import java.util.ArrayList;
import java.util.Collection;

public class ShoppingCart {
	private Collection<String> list;
	public ShoppingCart(){
		list=new ArrayList<String>();
	}
	public Collection<String> getList() {
		return list;
	}
	public void setList(Collection<String> list) {
		this.list = list;
	}
	
	public void add(String product){
		list.add(product);
	}
	
	
	@Override
	public String toString() {
		return "ShoppingCart [list=" + list + "]";
	}

	
	
}
