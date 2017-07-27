package bank.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bank.model.Account;

public interface AccountDao {
	void insertAccount(Account account) throws DataAccessException; //단일 계좌 개설
	List<Account> getAccountList() throws DataAccessException; //전체 계좌 조회
	Account getAccount(int id) throws DataAccessException; //단일 계좌 조회
	void updateAccount(Account account) throws DataAccessException;
}
