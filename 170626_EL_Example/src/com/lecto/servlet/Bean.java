package com.lecto.servlet;

public abstract class Bean {
	private String name;

	public Bean() {
		super();
		this.name="�̸�����";
	}
	public Bean(String name) {
		super();
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
