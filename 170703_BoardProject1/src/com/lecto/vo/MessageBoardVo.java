package com.lecto.vo;

import java.util.List;

public class MessageBoardVo {
	private String name;
	private int postNum;
	private int postIntro;
	private List<PostVo> postList;
	public MessageBoardVo() {
		super();
	}
	public MessageBoardVo(String name, int postNum, int postIntro, List<PostVo> postList) {
		super();
		this.name = name;
		this.postNum = postNum;
		this.postIntro = postIntro;
		this.postList = postList;
	}
	public String getName() {
		return name;
	}
	public int getPostNum() {
		return postNum;
	}
	public int getPostIntro() {
		return postIntro;
	}
	public List<PostVo> getPostList() {
		return postList;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public void setPostIntro(int postIntro) {
		this.postIntro = postIntro;
	}
	public void setPostList(List<PostVo> postList) {
		this.postList = postList;
	}
	
	public List<PostVo> getPostList(int fromIndex, int toIndex){
		return postList.subList(fromIndex, toIndex);
	}
	
	public int getPostListSize(){
		return postList.size();
	}
	@Override
	public String toString() {
		return "MessageBoardVo [name=" + name + ", postNum=" + postNum + ", postIntro=" + postIntro + ", postList="
				+ postList + "]";
	}
}
