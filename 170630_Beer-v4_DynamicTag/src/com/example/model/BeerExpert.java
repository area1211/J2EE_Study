package com.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BeerExpert {
	private Map<String, List<String>> map;
	
	public BeerExpert(){
		map=new HashMap<String, List<String>>();
		init();
	}
	
	public Map<String, List<String>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<String>> map) {
		this.map = map;
	}

	public void init(){
		ArrayList<String> brands=new ArrayList<String>();
		brands.add("Jack Amber");
		brands.add("Red Moose");
		map.put("amber", brands);
		
		ArrayList<String> brands2=new ArrayList<String>();
		brands2.add("Jail Pale Ale");
		brands2.add("Gout Stout");
		map.put("etc", brands2);
	}
	
	public List<String> getBrands(String color){
		if(map.get(color)==null){
			return map.get("etc");
		}
		return map.get("amber");

	}
}
