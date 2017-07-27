package com.lecto.model;

public class PostDetailBean extends PostThumbBean{
	
	private String body;
	
	public PostDetailBean(){
		
	}

	public PostDetailBean(PostThumbBean ptb, String body){
		super(ptb.getId(), ptb.getTitle(), ptb.getNickname(), ptb.getDate(), ptb.getHits(), ptb.getGood());
		this.body = body;
	}
	
	public PostDetailBean(String id, String title, String nickname, String date, int hits, int good, String body){
		super(id, title, nickname, date, hits, good);
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}

