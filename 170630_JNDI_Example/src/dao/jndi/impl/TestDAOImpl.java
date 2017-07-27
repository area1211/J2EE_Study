package dao.jndi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.jndi.BaseDAO;
import dao.jndi.DAOException;

public class TestDAOImpl extends BaseDAO implements TestDAO {

	@Override
	public List<TestVO> testList() throws DAOException {
		List<TestVO> resultList = new ArrayList<TestVO>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = this.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM testdata;");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				resultList.add(new TestVO(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(3))));
			}
		}  catch (SQLException se){
			se.printStackTrace();
			throw new DAOException();
		}  finally {
			this.closeDBObjects(rs, stmt, conn);
		}
		return resultList;
	}

	@Override
	public void testInsert(TestVO vo) throws DAOException {
		// TODO Auto-generated method stub
		this.testInsert(vo.getId(), vo.getFoo(), vo.getBar());
	}
	
	public void testInsert(int id, String foo, int bar) throws DAOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		try {
			conn = this.getConnection();
			stmt = conn.prepareStatement("INSERT INTO testdata VALUES ("+id+", \'"+foo+"\', "+bar+");");
			result = stmt.executeUpdate();
			
			if(result!=0){
				System.out.println("INSERT ¼º°ø.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException();
		} finally {
			this.closeDBObjects(null, stmt, conn);
		}
		
		
	}

}
