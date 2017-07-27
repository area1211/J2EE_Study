package com.lecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.lecto.vo.PostVo;
import com.lecto.vo.UserVo;

import dao.jndi.BaseDAO;
import dao.jndi.DAOException;

public class PostDAO extends BaseDAO{
	private List<PostVo> postList;
	
	public PostDAO(){
		postList = new LinkedList<PostVo>();
	}
	
	public boolean add(PostVo post){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			//CALL uploadPost('none', '프로시져테스트', '2017-07-05 12:39:00', '프로시져는쉬워라', 1, 0, 1, '정이노', 0);
			stmt = conn.prepareStatement("CALL uploadPost(?, ?, ?, ?, ?, ?, ?, ?, ?);");
			stmt.setString(1, "none");
			stmt.setString(2, post.getTitle());
			stmt.setString(3, post.getDate());
			stmt.setString(4, post.getBody());
			stmt.setInt(5, 1);
			stmt.setInt(6, 0);
			stmt.setInt(7, 1);
			stmt.setString(8, post.getNickname());
			stmt.setInt(9, 0);
			rs = stmt.executeQuery();
			
			
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, stmt, conn);
		}
		
		
		
		
		return postList.add(post);
	}
	
	public PostVo search(String id){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PostVo pv = null;
		try {
			conn = getConnection();
			//CALL uploadPost('none', '프로시져테스트', '2017-07-05 12:39:00', '프로시져는쉬워라', 1, 0, 1, '정이노', 0);
			stmt = conn.prepareStatement("select p_id, p_subject, p_title, "
			 		+ "(select u_nickname from user_tb where user_tb.u_id = post_tb.u_id) "
			 		+ ", p_date, p_body, p_public, p_id, p_hits from post_tb "
			 		+ "where mb_id=? and p_id = ?;");
			stmt.setInt(1, 1);
			stmt.setInt(2, Integer.parseInt(id));
			rs = stmt.executeQuery();
			
			while(rs.next()){
				pv=new PostVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), Boolean.parseBoolean(rs.getString(7)), rs.getString(8), Integer.parseInt(rs.getString(9)), 0);
			}
			
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, stmt, conn);
		}
		
		return pv;
	}
	
	public boolean delete(String id){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int res=0;
		try {
			conn = getConnection();
			//CALL uploadPost('none', '프로시져테스트', '2017-07-05 12:39:00', '프로시져는쉬워라', 1, 0, 1, '정이노', 0);
			stmt = conn.prepareStatement("delete from post_tb where mb_id=? and p_id = ?;");
			stmt.setInt(1, 1);
			stmt.setInt(2, Integer.parseInt(id));
			res = stmt.executeUpdate();
			
			
			
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, stmt, conn);
		}
		
		if(res==0)
			return false;
		return true;
	}
}
