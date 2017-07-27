package dao.jndi.impl;

import java.util.List;

import dao.jndi.DAO;
import dao.jndi.DAOException;

//DAOExeption을 발생시키기... 서비스계층에서 예외처리를 해야하니까 throws 해야함
public interface TestDAO extends DAO {
	List<TestVO> testList() throws DAOException;
	void testInsert(TestVO vo) throws DAOException;
}
