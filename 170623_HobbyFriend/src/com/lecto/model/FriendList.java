package com.lecto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendList {
	private List<String[]> list;
	private final Map<String, List<String>> mapList;
	
	public FriendList(){
		mapList = new HashMap<String, List<String>>();
		list=new ArrayList<String[]>();
		init();
	}
	
	public void init(){
		add("����ȣ", "�౸");
		add("������", "�౸");
		add("������", "�౸");
		add("������", "RPG����");
		add("������", "��ȭ����");
		add("�̽±�", "��ȭ����");
	}
	
	public void add(String name, String hobby){
		if(name==null || hobby==null) return;
		
		String[] ary = {name, hobby};
		list.add(ary);
	}
	
	public List<String> getFriends(String hobby){
		if(hobby==null) return null;
		
		List<String> friends = new ArrayList<String>();
		
		for(String[] tmp: list){
			if(tmp[1].equals(hobby)){
				friends.add(tmp[0]);
			}
		}
		
		return friends;
	}

	@Override
	public String toString() {
		return "FriendList [list=" + list + "]";
	}
	
	
}
