package ui;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi {
	Scanner sc = new Scanner(System.in);
	private SelectTeamUi selectTeamUi;
	private SelectPlayerUi selectPlayerUi;
	
	public SelectPlayerUi getSelectPlayerUi() {
		return selectPlayerUi;
	}

	public void setSelectPlayerUi(SelectPlayerUi selectPlayerUi) {
		this.selectPlayerUi = selectPlayerUi;
	}

	public SelectTeamUi getSelectTeamUi() {
		return selectTeamUi;
	}

	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}

	protected int showMenu(){
		System.out.println("--------------------------------------------------");
		System.out.println("1. 종료");
		System.out.println("2. 팀 목록");
		System.out.println("3. 선수 목록");
		System.out.print("* 선택 > ");
		int sel = Integer.parseInt(sc.next());
		return sel;
	}
	
	protected void execute(int number){
		switch(number){
		case 1: System.out.println("종료되었습니다."); System.exit(0);
		case 2: selectTeamUi.show(); break;
		case 3: 
			System.out.print("** 팀 이름 입력 > ");
			String name = sc.next();
			selectPlayerUi.show(name); break;
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
