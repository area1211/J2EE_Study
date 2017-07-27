package com.real.command;

import com.lecto.dao.UserDAO;

public class LoginCommand {
	private UserDAO ud;
	
	public LoginCommand(){
		ud=new UserDAO();
	}
	
	public String checkVaridity(String id, String pwd){
		
		String nickname = ud.check(id, pwd);
		
		return nickname;
	}
}
