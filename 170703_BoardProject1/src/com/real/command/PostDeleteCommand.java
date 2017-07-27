package com.real.command;

import com.lecto.dao.PostDAO;

public class PostDeleteCommand {
	private PostDAO pd;
	
	public PostDeleteCommand(){
		pd=new PostDAO();
	}
	
	public boolean delete(String id){
		return pd.delete(id);
	}
}
