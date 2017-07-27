package com.lecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lecto.vo.MessageBoardVo;
import com.lecto.vo.PostVo;

import dao.jndi.BaseDAO;
import dao.jndi.DAOException;

public class MessageBoardDAO extends BaseDAO {
	private List<MessageBoardVo> messageBoardList;

	public MessageBoardDAO() {
		super();
	}

	public MessageBoardDAO(List<MessageBoardVo> messageBoardList) {
		super();
		this.messageBoardList = messageBoardList;
	}

	public List<MessageBoardVo> getMessageBoardList() {
		return messageBoardList;
	}

	public void setMessageBoardList(List<MessageBoardVo> messageBoardList) {
		this.messageBoardList = messageBoardList;
	}

	@Override
	public String toString() {
		return "MessageBoardDAO [messageBoardList=" + messageBoardList + "]";
	}
	
	public void init(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			 conn = getConnection();
			 stmt = conn.prepareStatement("");
			 rs = stmt.executeQuery();
			 
			 while(rs.next()){
				 
			 }
			 
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeDBObjects(rs, stmt, conn);
		}
	}
	
	public int getPostListSize(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int size=0;
		try {
			 conn = getConnection();
			 stmt = conn.prepareStatement("select count(p_id) from post_tb where mb_id = ?;");
			 stmt.setInt(1, 1);
			 rs = stmt.executeQuery();
			 
			 while(rs.next()){
				 size = Integer.parseInt(rs.getString(1));
			 }
			 
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeDBObjects(rs, stmt, conn);
		}
		
		return size;
	}
	
	public List<PostVo> getPostList(int boardId, int fromIndex, int toIndex){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<PostVo> list = new ArrayList<PostVo>();
		PostVo temp=null;
		
		try {
			 conn = getConnection();
			 stmt = conn.prepareStatement("select p_id, p_subject, p_title, "
			 		+ "(select u_nickname from user_tb where user_tb.u_id = post_tb.u_id) "
			 		+ ", p_date, p_body, p_public, p_id, p_hits from post_tb "
			 		+ "where mb_id=? and p_id >= ? and p_id <= ? order by p_id desc;");
			 
			 stmt.setInt(1, boardId);
			 stmt.setInt(2, fromIndex);
			 stmt.setInt(3, toIndex);
			 rs = stmt.executeQuery();
			 
			 while(rs.next()){
				temp = new PostVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
								, rs.getString(6), Boolean.parseBoolean(rs.getString(7)), rs.getString(8), Integer.parseInt(rs.getString(9)), 0);			 
				list.add(temp);
			 }
			 
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeDBObjects(rs, stmt, conn);
		}
		
		return list;
	}
}
