package bank.ui;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi {
	Scanner sc = new Scanner(System.in);
	private InsertAccountUi insertAccountUi;
	private SelectAccountUi selectAccountUi;
//	private SelectTeamUi selectTeamUi;
//	private PlayerListUi playerListUi;
//	private InsertPlayerUi insertPlayerUi;
//	private InsertTeamUi insertTeamUi;
//	private SelectPlayerUi selectPlayerUi;
//	
//
//	public void setSelectPlayerUi(SelectPlayerUi selectPlayerUi) {
//		this.selectPlayerUi = selectPlayerUi;
//	}
//
//	public void setPlayerListUi(PlayerListUi selectPlayerUi) {
//		this.playerListUi = selectPlayerUi;
//	}
//
//	public SelectTeamUi getSelectTeamUi() {
//		return selectTeamUi;
//	}
//
//	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
//		this.selectTeamUi = selectTeamUi;
//	}
//	public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi) {
//		this.insertPlayerUi = insertPlayerUi;
//	}
//	public void setInsertTeamUi(InsertTeamUi insertTeamUi) {
//		this.insertTeamUi = insertTeamUi;
//	}

	public void setSelectAccountUi(SelectAccountUi selectAccountUi) {
		this.selectAccountUi = selectAccountUi;
	}
	public void setInsertAccountUi(InsertAccountUi insertAccountUi) {
		this.insertAccountUi = insertAccountUi;
	}



	protected int showMenu(){
		System.out.println("--------------------------------------------------");
		System.out.println("0. 종료");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌조회");
		System.out.println("5. 전체계좌 조회");
		System.out.print("* 선택 > ");
		int sel = Integer.parseInt(sc.next());
		return sel;
	}
	
	

	protected void execute(int number){
		switch(number){
		case 0: System.out.println("종료되었습니다."); System.exit(0);
		case 1: insertAccountUi.show(); break;
		case 2: selectAccountUi.showDeposit(); break;
		case 3: selectAccountUi.showWithdraw(); break;
//			System.out.print("** 팀 이름 입력 > ");
//			String name = sc.next();
//			playerListUi.show(name); 
//			playerListUi.show();
//			break;
		case 4: selectAccountUi.show(); break;
		case 5: selectAccountUi.showAccountList(); break;
		}
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		MenuUi menuUi = context.getBean(MenuUi.class);
		while(true){			
			menuUi.execute(menuUi.showMenu());
		}
	}

}
