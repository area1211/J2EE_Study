package com.lecto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	private Connection conn;
	private final String driverClassName;
	private final String url;
	private final String id;
	private final String pwd;
	
	public DBConnection(String driverClassName, String url, String id, String pwd){
		this.driverClassName=driverClassName;
		this.url=url;
		this.id=id;
		this.pwd=pwd;
		
		conn = getConn();
	}
	
	public Connection getConn(){
		try {
			if(conn==null||conn.isClosed()){
				Class.forName(driverClassName);
				conn = DriverManager.getConnection(url, id, pwd);
				System.out.println("�����ͺ��̽��� ����Ǿ����ϴ�.");
			}
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC ����̹��� ã�� �� �����Ϥ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConn(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
