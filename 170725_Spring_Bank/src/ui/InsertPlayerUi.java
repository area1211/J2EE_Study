package ui;

import java.util.Scanner;

import dao.PlayerDao;
import dao.TeamDao1;
import model.Player;
import model.Team;

public class InsertPlayerUi {
	private TeamDao1 teamDao;
	private PlayerDao playerDao;
	
	Scanner sc = new Scanner(System.in);
	
	public void setTeamDao(TeamDao1 teamDao) {
		this.teamDao = teamDao;
	}
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	
	public void show(){
		System.out.print("선수ID: ");
		Integer id = Integer.parseInt(sc.nextLine());
		System.out.print("선수명: ");
		String name = sc.nextLine();
		System.out.print("팀ID: ");
		Integer team_id = Integer.parseInt(sc.nextLine());
		
		Team team = teamDao.getTeam(team_id);
		if(team == null){
			System.out.println("없는 팀 ID 입니다.");
			return;
		}
		
		Player player = new Player();
		player.setId(id);
		player.setName(name);
		player.setTeam(team);
		
		playerDao.insertPlayer(player);
		System.out.printf("팀 %s에 %s 선수를 추가했습니다.", player.getTeam().getName(), player.getName());
	}
	

}
