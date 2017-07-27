package bank.ui;

import java.util.Scanner;

import bank.dao.AccountDao;
import bank.model.Account;

public class InsertAccountUi {
	private AccountDao accountDao;

	Scanner sc = new Scanner(System.in);
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public void show(){
		System.out.println("[계좌개설]");
		System.out.print("* 계좌번호 : ");
		int id=Integer.parseInt(sc.nextLine());
		System.out.print("* 이름 : ");
		String name=sc.nextLine();
		System.out.print("* 입금액 : ");
		int deposit=Integer.parseInt(sc.nextLine());
		
		Account account=accountDao.getAccount(id);
		if(account != null){
			System.out.println("**** 이미 개설된 계좌번호 입니다! ****");
			return;
		}
		account=new Account(id, name, deposit);
		accountDao.insertAccount(account);
	}
}
