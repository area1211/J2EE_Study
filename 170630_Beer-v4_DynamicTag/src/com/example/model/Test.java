package com.example.model;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeerExpert be=new BeerExpert();
		System.out.println("TEST1");
		System.out.println(be.getBrands("amber"));
		
		System.out.println(be.getMap().get("amber"));
	}

}
