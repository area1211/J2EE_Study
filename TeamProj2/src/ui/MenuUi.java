package ui;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi {
	Scanner sc = new Scanner(System.in);
	private SelectTeamUi selectTeamUi;
	private PlayerListUi playerListUi;
	private InsertPlayerUi insertPlayerUi;
	private InsertTeamUi insertTeamUi;
	private SelectPlayerUi selectPlayerUi;
	

	public void setSelectPlayerUi(SelectPlayerUi selectPlayerUi) {
		this.selectPlayerUi = selectPlayerUi;
	}

	public void setPlayerListUi(PlayerListUi selectPlayerUi) {
		this.playerListUi = selectPlayerUi;
	}

	public SelectTeamUi getSelectTeamUi() {
		return selectTeamUi;
	}

	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}
	public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi) {
		this.insertPlayerUi = insertPlayerUi;
	}
	public void setInsertTeamUi(InsertTeamUi insertTeamUi) {
		this.insertTeamUi = insertTeamUi;
	}

	protected int showMenu(){
		System.out.println("--------------------------------------------------");
		System.out.println("1. ����");
		System.out.println("2. �� ���");
		System.out.println("3. ���� ���");
		System.out.println("4. ���� �߰�");
		System.out.println("5. �� �߰�");
		System.out.println("6. ���� ����, ����");
		System.out.print("* ���� > ");
		int sel = Integer.parseInt(sc.next());
		return sel;
	}
	
	

	protected void execute(int number){
		switch(number){
		case 1: System.out.println("����Ǿ����ϴ�."); System.exit(0);
		case 2: selectTeamUi.show(); break;
		case 3: 
//			System.out.print("** �� �̸� �Է� > ");
//			String name = sc.next();
//			playerListUi.show(name); 
			playerListUi.show();
			break;
		case 4: insertPlayerUi.show(); break;
		case 5: insertTeamUi.show(); break;
		case 6: selectPlayerUi.show(); break;
		}
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MenuUi menuUi = context.getBean(MenuUi.class);
		//int sel = menuUi.showMenu();
		while(true){			
			menuUi.execute(menuUi.showMenu());
		}
	}

}
