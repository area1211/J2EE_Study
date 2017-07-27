package ui;

import java.util.Scanner;

import dao.TeamDao1;
import model.Team;

public class InsertTeamUi {
	private TeamDao1 teamDao;
	
	Scanner sc = new Scanner(System.in);
	
	public void setTeamDao(TeamDao1 teamDao) {
		this.teamDao = teamDao;
	}
	
	public void show(){
		System.out.print("∆¿ID: ");
		Integer id = Integer.parseInt(sc.nextLine());
		System.out.print("∆¿¿Ã∏ß: ");
		String name = sc.nextLine();
		
		Team team = teamDao.getTeam(id);
		if(team != null){
			System.out.println("¿ÃπÃ ¿÷¥¬ ∆¿ ID ¿‘¥œ¥Ÿ.");
			return;
		}
		
		team = new Team();
		team.setId(id);
		team.setName(name);
		
		teamDao.insertTeam(team);
		System.out.printf("∆¿ ID %d¿Œ ∆¿∏Ì %s∏¶ √ﬂ∞°«ﬂΩ¿¥œ¥Ÿ.\n", team.getId(), team.getName());
	}
}
