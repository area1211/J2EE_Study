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
		System.out.print("����ID: ");
		Integer id = Integer.parseInt(sc.nextLine());
		System.out.print("������: ");
		String name = sc.nextLine();
		System.out.print("��ID: ");
		Integer team_id = Integer.parseInt(sc.nextLine());
		
		Team team = teamDao.getTeam(team_id);
		if(team == null){
			System.out.println("���� �� ID �Դϴ�.");
			return;
		}
		
		Player player = new Player();
		player.setId(id);
		player.setName(name);
		player.setTeam(team);
		
		playerDao.insertPlayer(player);
		System.out.printf("�� %s�� %s ������ �߰��߽��ϴ�.", player.getTeam().getName(), player.getName());
	}
	

}
