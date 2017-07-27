package com.lecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lecto.vo.RelationVO;

import dao.jndi.BaseDAO;
import dao.jndi.DAOException;

public class RelationConnDAO extends BaseDAO{
	public List<RelationVO> searchRelationVO(int sender, int relation){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<RelationVO> list = new ArrayList<RelationVO>();

		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("select * from relation_view where sender_num = ? and request = ?;");
			stmt.setInt(1, sender);
			stmt.setInt(2, relation);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				list.add(new RelationVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
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
		
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println("test");
		List<RelationVO> list = new RelationConnDAO().searchRelationVO(2, 2);
		for(RelationVO tmp: list)
			System.out.println(tmp);
	}
}
