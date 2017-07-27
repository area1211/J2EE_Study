package dao;

import org.springframework.dao.DataAccessException;

import model.Team;

public interface TeamDao1 {
	Team getTeam(Integer teamId) throws DataAccessException;
	void insertTeam(Team team) throws DataAccessException;
}
