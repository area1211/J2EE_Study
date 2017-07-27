package ui;

import java.util.List;
import java.util.Scanner;

import dao.PlayerDao;
import dao.TeamDao1;
import model.Player;
import model.Team;

public class PlayerListUi {
	private PlayerDao playerDao;
	private TeamDao1 teamDao;//��������->����
	public void setTeamDao(TeamDao1 teamDao) {
		this.teamDao = teamDao;
	}
	Scanner sc = new Scanner(System.in);
	

	public PlayerDao getPlayerDao() {
		return playerDao;
	}
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	public void show(){
		System.out.println("[������� ��ȸ]");
		System.out.print("�� ID �Է� : ");
		Integer teamId = Integer.parseInt(sc.nextLine());
		Team team=teamDao.getTeam(teamId);
		
		if(team == null){
			System.out.println("���� ���Դϴ�!");
			return;
		}
		
		showPlayerList(this.playerDao.getPlayerList(teamId));
	}
	public void show(String name){
		showPlayerList(this.playerDao.getPlayerList(name));
	}
	protected void showPlayerList(List<Player> playerList){
		System.out.println("------------------");
		System.out.println("ID   �̸�       �Ҽ����̸�");
		for(Player player: playerList){
			System.out.printf("%d %s %s\n", player.getId(), player.getName(), player.getTeam().getName());
		}
	}
}
