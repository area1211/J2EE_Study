package com.real.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lecto.dao.MessageBoardDAO;
import com.lecto.model.PostThumbBean;
import com.lecto.vo.PostVo;

public class BoardListCommand {
	private MessageBoardDAO mbd;

	public BoardListCommand() {
		super();
		mbd=new MessageBoardDAO();
	}

	public BoardListCommand(MessageBoardDAO mbd) {
		super();
		this.mbd = mbd;
	}
	
	
	public int getPostListSize(){
		return mbd.getPostListSize();
	}
	
	public List<PostThumbBean> changeBoard(int boardId, int fromIndex, int toIndex){
		List<PostVo> getList = mbd.getPostList(boardId, fromIndex, toIndex);
		List<PostThumbBean> sendList = new ArrayList<PostThumbBean>();
		
		for(PostVo tmp: getList){
			sendList.add(new PostThumbBean(tmp.getId(), tmp.getTitle(), tmp.getNickname(), checkDate(tmp.getDate()),
					tmp.getHits(), tmp.getRecommendationNum()));
		}
		
		return sendList;
	}
	
	public String checkDate(String wDate){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String now = format.format(date);
//		System.out.println("현재시간 : [" + now + "]" );
//		System.out.println("글쓴시간 : [" + wDate.substring(0, 10) + "]");
		if(now.equals(wDate.substring(0, 10))){
			return wDate.substring(10, wDate.length()-5);
		}
		return wDate.substring(0, 10);
	}
}
