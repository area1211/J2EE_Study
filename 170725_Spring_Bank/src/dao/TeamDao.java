package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Team;

public interface TeamDao {
	List<Team> getTeamList() throws DataAccessException;
	void insertTeam(Team team) throws DataAccessException;
}
