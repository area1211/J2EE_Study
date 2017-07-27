package com.lecto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.lecto.db.DBConnection;

public class EmployeesDAO {
	private Map<Integer, EmployeesVO> map;
	private DBConnection dbc;
	
	public EmployeesDAO(){
		map = new HashMap<Integer, EmployeesVO>();
	}
	
	public EmployeesDAO(DBConnection dbc){
		this.dbc=dbc;
		map = new HashMap<Integer, EmployeesVO>();
		init();
	}
	
	public EmployeesVO search(String firstName, String lastName){
		if(firstName==null || lastName==null) return null;
		Set<Integer> ks = map.keySet();
		EmployeesVO result = null;
		for(Integer id: ks){
			result = map.get(id);
			if(result.getFirstName().equals(firstName) && result.getLastName().equals(lastName)){
				return result;
			}
		}
		return null;
	}
	
	public void init(){
		Connection conn = dbc.getConn();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE from EMPLOYEES");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				map.put(Integer.parseInt(rs.getString(1)),
						new EmployeesVO(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) ));
			}
			System.out.println("Init °á°ú : " + map.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(rs!=null){
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}

