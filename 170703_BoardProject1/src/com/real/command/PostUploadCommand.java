package com.real.command;

import com.lecto.dao.PostDAO;
import com.lecto.vo.PostVo;

public class PostUploadCommand {
	private PostDAO pd;
	
	public PostUploadCommand(){
		pd=new PostDAO();
	}
	
	
	public boolean add(String title, String body, String date, String nickname, boolean publicConfig){
		PostVo post = new PostVo("0", "none", title, nickname, date, body, publicConfig, "0", 0, 0);
		
		
		
		return pd.add(post);
	}
}
