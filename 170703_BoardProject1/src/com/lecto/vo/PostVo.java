package com.lecto.vo;

public class PostVo {
	private String id;
	private String subject;
	private String title;
	private String nickname;
	private String date;
	
	
	private String body;
	private boolean publicConfig;
	private String pid;
	private int hits;
	private int recommendationNum;
	public PostVo() {
		super();
	}
	
	
	public PostVo(String id, String subject, String title, String nickname, String date, String body,
			boolean publicConfig, String pid, int hits, int recommendationNum) {
		super();
		this.id = id;
		this.subject = subject;
		this.title = title;
		this.nickname = nickname;
		this.date = date;
		this.body = body;
		this.publicConfig = publicConfig;
		this.pid = pid;
		this.hits = hits;
		this.recommendationNum = recommendationNum;
	}


	public String getId() {
		return id;
	}
	public String getSubject() {
		return subject;
	}
	public String getTitle() {
		return title;
	}
	public String getNickname() {
		return nickname;
	}
	public String getDate() {
		return date;
	}
	public int getHits() {
		return hits;
	}
	public int getRecommendationNum() {
		return recommendationNum;
	}
	public String getBody() {
		return body;
	}
	public boolean isPublicConfig() {
		return publicConfig;
	}
	public String getPid() {
		return pid;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public void setRecommendationNum(int recommendationNum) {
		this.recommendationNum = recommendationNum;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setPublicConfig(boolean publicConfig) {
		this.publicConfig = publicConfig;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "PostVo [id=" + id + ", subject=" + subject + ", title=" + title + ", nickname=" + nickname + ", date="
				+ date + ", hits=" + hits + ", recommendationNum=" + recommendationNum + ", body=" + body
				+ ", publicConfig=" + publicConfig + ", pid=" + pid + "]";
	}
	
	
}
