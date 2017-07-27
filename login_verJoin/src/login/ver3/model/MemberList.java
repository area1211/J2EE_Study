package login.ver3.model;

import java.util.HashMap;
import java.util.Map;

public class MemberList {
	private Map<String, String[]> map;
	
	
	public MemberList(){
		map=new HashMap<String, String[]>();
		init();
	}
	
	public void init(){
		String[] info={"qwer@1234", "정인호"};
		String[] info2={"qwer@1234", "정인둘"};
		String[] info3={"qwer@1234", "정인셋"};
		map.put("area1211", info);
		map.put("area1212", info2);
		map.put("area1213", info3);
	}
	
	public Map<String, String[]> getMap() {
		return map;
	}

	public void setMap(Map<String, String[]> map) {
		this.map = map;
	}
	
	public void add(String email, String name, String pwd){
		String[] info={pwd, name};
		map.put(email, info);
	}

	public String[] checkMember(String id, String pwd){
		if(map.containsKey(id)){ // id가 존재한다면
			if(map.get(id)[0].equals(pwd)){
				String[] info={id, map.get(id)[0], map.get(id)[1]}; 
				return info; // 비밀번호 일치, 멤버체크성공
			}
			else{
				String[] info={"-2", "비밀번호 불일치"};
				return info; // 비밀번호 불일치
			}
		}
		String[] info={"-1", "아이디 존재하지 않음"};
		return info; // 코드 -1 : 아이디 존재하지 않음
	}
}
