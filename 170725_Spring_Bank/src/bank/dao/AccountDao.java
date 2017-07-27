package bank.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bank.model.Account;

public interface AccountDao {
	void insertAccount(Account account) throws DataAccessException; //���� ���� ����
	List<Account> getAccountList() throws DataAccessException; //��ü ���� ��ȸ
	Account getAccount(int id) throws DataAccessException; //���� ���� ��ȸ
	void updateAccount(Account account) throws DataAccessException;
}
