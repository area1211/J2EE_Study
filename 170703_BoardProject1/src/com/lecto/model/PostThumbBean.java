package com.lecto.model;

public class PostThumbBean {
	private String id;
	private String title;
	private String nickname;
	private String date;
	private int hits;
	private int good;
	public PostThumbBean() {
		super();
	}
	public PostThumbBean(String id, String title, String nickname, String date, int hits, int good) {
		super();
		this.id = id;
		this.title = title;
		this.nickname = nickname;
		this.date = date;
		this.hits = hits;
		this.good = good;
	}
	public String getId() {
		return id;
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
	public int getGood() {
		return good;
	}
	public void setId(String id) {
		this.id = id;
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
	public void setGood(int good) {
		this.good = good;
	}

	

}
