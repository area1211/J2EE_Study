package login.ver2.model;

import java.util.HashMap;
import java.util.Map;

public class MemberList {
	private Map<String, String[]> map;
	
	public MemberList(){
		map=new HashMap<String, String[]>();
		init();
	}
	
	public void init(){
		String[] info={"qwer@1234", "����ȣ"};
		String[] info2={"qwer@1234", "���ε�"};
		String[] info3={"qwer@1234", "���μ�"};
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

	public String[] checkMember(String id, String pwd){
		if(map.containsKey(id)){ // id�� �����Ѵٸ�
			if(map.get(id)[0].equals(pwd)){
				String[] info={id, map.get(id)[0], map.get(id)[1]}; 
				return info; // ��й�ȣ ��ġ, ���üũ����
			}
			else{
				String[] info={"-2", "��й�ȣ ����ġ"};
				return info; // ��й�ȣ ����ġ
			}
		}
		String[] info={"-1", "���̵� �������� ����"};
		return info; // �ڵ� -1 : ���̵� �������� ����
	}
}
