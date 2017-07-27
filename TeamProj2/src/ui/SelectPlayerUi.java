package ui;

import java.util.Scanner;

import dao.PlayerDao;
import dao.TeamDao;
import dao.TeamDao1;
import model.Player;
import model.Team;

public class SelectPlayerUi {
	private PlayerDao playerDao;
	private TeamDao1 teamDao;
	public void setTeamDao(TeamDao1 teamDao) {
		this.teamDao = teamDao;
	}


	Scanner sc = new Scanner(System.in);
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	
	public void show(){
		System.out.println("[���� ��ȸ]");
		System.out.print("����ID : ");
		
		Integer id = Integer.parseInt(sc.nextLine());
		Player player = playerDao.getPlayer(id);
		if(player == null){
			System.out.println("���� ���� ��ȣ�Դϴ�.");
			return;
		}
		System.out.println("ID  �̸�  ����");
		System.out.printf("%d  %s  %s\n", player.getId(), player.getName(), player.getTeam().getName());
		System.out.println();
		
		System.out.print("1. ����/2. ���� /3. ����: ");
		int sel = Integer.parseInt(sc.nextLine());
		
		switch(sel){
		case 3:
		case 1:
			showUpdate(player);
			break;
		case 2:
			showDelete(player);
			break;
		}
		
	}
	
	
	public void showUpdate(Player player){
		System.out.println("[���� ����]");
		System.out.print("�̸� : "); player.setName(sc.nextLine());
		System.out.print("��ID : ");
		Integer team_id = Integer.parseInt(sc.nextLine());
		Team team = teamDao.getTeam(team_id);
		if(team==null){
			System.out.println("���� �� ID �Դϴ�.");
			return;
		}
		player.setTeam(team);
		playerDao.updatePlayer(player);
		System.out.printf("%s ������ ������ ����Ǿ����ϴ�.\n", player.getName());
	}
	
	public void showDelete(Player player){
		System.out.println("[���� ����]");
		playerDao.deletePlayer(player);
		System.out.printf("%s ������ ������ �����Ǿ����ϴ�.\n", player.getName());
	}
}
