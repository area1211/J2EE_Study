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
		System.out.println("[선수 조회]");
		System.out.print("선수ID : ");
		
		Integer id = Integer.parseInt(sc.nextLine());
		Player player = playerDao.getPlayer(id);
		if(player == null){
			System.out.println("없는 선수 번호입니다.");
			return;
		}
		System.out.println("ID  이름  팀명");
		System.out.printf("%d  %s  %s\n", player.getId(), player.getName(), player.getTeam().getName());
		System.out.println();
		
		System.out.print("1. 변경/2. 삭제 /3. 이전: ");
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
		System.out.println("[선수 변경]");
		System.out.print("이름 : "); player.setName(sc.nextLine());
		System.out.print("팀ID : ");
		Integer team_id = Integer.parseInt(sc.nextLine());
		Team team = teamDao.getTeam(team_id);
		if(team==null){
			System.out.println("없는 팀 ID 입니다.");
			return;
		}
		player.setTeam(team);
		playerDao.updatePlayer(player);
		System.out.printf("%s 선수의 정보가 변경되었습니다.\n", player.getName());
	}
	
	public void showDelete(Player player){
		System.out.println("[선수 삭제]");
		playerDao.deletePlayer(player);
		System.out.printf("%s 선수의 정보가 삭제되었습니다.\n", player.getName());
	}
}
