package bank.ui;

import java.util.List;
import java.util.Scanner;

import bank.dao.AccountDao;
import bank.model.Account;

public class SelectAccountUi {
	Scanner sc = new Scanner(System.in);
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public void show(){
		System.out.println("[계좌조회]");
		System.out.print("* 계좌번호 : ");
		Integer id = Integer.parseInt(sc.nextLine());
		Account account = accountDao.getAccount(id);
		if(account == null){
			System.out.println("**** 존재하지 않는 계좌번호입니다! ****");
			return;
		} else {
			System.out.printf("** 계좌번호 : %d, 이름 : %s, 잔액 : %d원\n", account.getId(), account.getName(), account.getBalance());
		}
	}
	

	public void showDeposit(){
		System.out.println("[입금]");
		System.out.print("* 계좌번호 : ");
		Integer id = Integer.parseInt(sc.nextLine());
		Account account = accountDao.getAccount(id);
		if(account == null){
			System.out.println("**** 존재하지 않는 계좌번호입니다! ****");
			return;
		}
		synchronized (account){
			System.out.printf("** %s님의 현재 잔액은 %d원입니다. 입금액을 입력해주세요.\n", account.getName(), account.getBalance());
			
			
			System.out.print("* 입금액 : ");
			Integer deposit = Integer.parseInt(sc.nextLine());
			if(deposit<=0){
				System.out.println("**** 잘못된 입금액을 입력하셨습니다. ****");
				return;
			}
			account.setBalance(account.getBalance()+deposit);
			//System.out.println("......변경된잔액:"+account.getBalance());
			this.accountDao.updateAccount(account);
			System.out.printf("%d계좌에서 %d원 입금되었습니다.", account.getId(), deposit);
		}
		
		//account = accountDao.getAccount(id);
		//System.out.println("......DB로부터..변경된잔액:"+account.getBalance());
	}
	
	public void showWithdraw(){
		System.out.println("[출금]");
		System.out.print("* 계좌번호 : ");
		Integer id = Integer.parseInt(sc.nextLine());
		Account account = accountDao.getAccount(id);
		if(account == null){
			System.out.println("**** 존재하지 않는 계좌번호입니다! ****");
			return;
		}
		synchronized (account){
			System.out.printf("** %s님의 현재 잔액은 %d원입니다. 출금액을 입력해주세요.\n", account.getName(), account.getBalance());

			
			System.out.print("* 출금액 : ");
			Integer withdraw = Integer.parseInt(sc.nextLine());
			if(withdraw>account.getBalance()){
				System.out.println("**** 현재 잔액을 초과한 출금액 입니다. ****");
				return;
			}
			account.setBalance(account.getBalance()-withdraw);
			
			this.accountDao.updateAccount(account);
			System.out.printf("%d계좌에서 %d원 출금되었습니다.", account.getId(), withdraw);
		}
		
	}
	
	public void showAccountList(){
		List<Account> accountList = accountDao.getAccountList();
		System.out.println("[전체 계좌 조회]");
		for(Account account: accountList){
			System.out.printf("** 계좌번호 : %d, 이름 : %s, 잔액 : %d원\n", account.getId(), account.getName(), account.getBalance());
		}
	}
}
