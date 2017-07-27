package ui;

import java.util.List;

import dao.TeamDao;
import model.Team;

public class SelectTeamUi {
	private TeamDao teaDao;
	
	public void setTeamDao(TeamDao teamDao){
		this.teaDao=teamDao;
		
	}

	public void show(){
		showTeamList(this.teaDao.getTeamList());
	}

	protected void showTeamList(List<Team> teamList){
		System.out.println("------------------");
		System.out.println(" �������     �� ���");
		System.out.println("ID   �̸�");
		for(Team team: teamList){
			System.out.printf("%d %s\n", team.getId(), team.getName() );
		}
	}
}
