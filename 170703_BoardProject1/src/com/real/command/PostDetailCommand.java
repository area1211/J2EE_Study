package com.real.command;

import com.lecto.dao.PostDAO;
import com.lecto.model.PostDetailBean;
import com.lecto.vo.PostVo;

public class PostDetailCommand {
	private PostDAO pd;
	
	public PostDetailCommand(){
		pd=new PostDAO();
	}
	
	public PostDetailBean search(String id){
		PostVo pv = pd.search(id);
		
		return new PostDetailBean(pv.getId(), pv.getTitle(), pv.getNickname(), pv.getDate(), pv.getHits(), pv.getRecommendationNum(), pv.getBody());	
	}
}
