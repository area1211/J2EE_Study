package dao.jndi.impl;

import java.util.List;

import dao.jndi.DAO;
import dao.jndi.DAOException;

//DAOExeption�� �߻���Ű��... ���񽺰������� ����ó���� �ؾ��ϴϱ� throws �ؾ���
public interface TestDAO extends DAO {
	List<TestVO> testList() throws DAOException;
	void testInsert(TestVO vo) throws DAOException;
}
