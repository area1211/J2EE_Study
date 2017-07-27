package com.lecto.vo;

public class UserVo {
	private String id;
	private String pwd;
	private String nickname;
	public UserVo() {
		super();
	}
	public UserVo(String id, String pwd, String nickname) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", pwd=" + pwd + ", nickname=" + nickname + "]";
	}
	
	
}
