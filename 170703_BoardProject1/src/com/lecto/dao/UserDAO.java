package com.lecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lecto.vo.UserVo;

import dao.jndi.BaseDAO;
import dao.jndi.DAOException;

public class UserDAO extends BaseDAO {
	private List<UserVo> uList;
	
	public UserDAO(){
		uList = new ArrayList<UserVo>();
		init();
	}
	
	public UserVo search(String id){
		for(UserVo tmp: uList){
			if(tmp.getId().equals(id)){
				return tmp;
			}
		}
		
		return null;
	}
	
	public String check(String id, String pwd){
		UserVo user = search(id);
		if(user==null)
			return null;
		if(user.getPwd().equals(pwd)){
			System.out.println("¿œƒ°¿Ã");
			return user.getNickname();
		}
		return null;
	}
	
	public void init(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from user_tb");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				uList.add(new UserVo(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		
			closeDBObjects(rs, stmt, conn);
		}
	}
}
