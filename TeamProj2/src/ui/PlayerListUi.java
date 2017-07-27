package ui;

import java.util.List;
import java.util.Scanner;

import dao.PlayerDao;
import dao.TeamDao1;
import model.Player;
import model.Team;

public class PlayerListUi {
	private PlayerDao playerDao;
	private TeamDao1 teamDao;//주입하자->했응
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
		System.out.println("[선수목록 조회]");
		System.out.print("팀 ID 입력 : ");
		Integer teamId = Integer.parseInt(sc.nextLine());
		Team team=teamDao.getTeam(teamId);
		
		if(team == null){
			System.out.println("없는 팀입니다!");
			return;
		}
		
		showPlayerList(this.playerDao.getPlayerList(teamId));
	}
	public void show(String name){
		showPlayerList(this.playerDao.getPlayerList(name));
	}
	protected void showPlayerList(List<Player> playerList){
		System.out.println("------------------");
		System.out.println("ID   이름       소속팀이름");
		for(Player player: playerList){
			System.out.printf("%d %s %s\n", player.getId(), player.getName(), player.getTeam().getName());
		}
	}
}
