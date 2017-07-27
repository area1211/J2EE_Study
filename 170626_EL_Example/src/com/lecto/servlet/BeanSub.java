package com.lecto.servlet;

public class BeanSub extends Bean{
	private String subName;
	
	public BeanSub(){
		this.subName="∫ÛSUB";
	}
	
	public BeanSub(String name){
		super(name);
		this.subName="∫ÛSUB";
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}
	
}
