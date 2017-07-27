package ui;

import java.util.List;

import dao.PlayerDao;
import model.Player;
import model.Team;

public class SelectPlayerUi {
	private PlayerDao playerDao;
	
	

	public PlayerDao getPlayerDao() {
		return playerDao;
	}
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	public void show(){
		showPlayerList(this.playerDao.getPlayerList());
	}
	public void show(String name){
		showPlayerList(this.playerDao.getPlayerList(name));
	}
	protected void showPlayerList(List<Player> playerList){
		System.out.println("------------------");
		System.out.println("ID   ¿Ã∏ß       º“º”∆¿");
		for(Player player: playerList){
			System.out.printf("%d %s %s\n", player.getId(), player.getName(), player.getTeam_name());
		}
	}
}
