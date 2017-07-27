package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Player;

public interface PlayerDao {
	List<Player> getPlayerList() throws DataAccessException;
	List<Player> getPlayerList(String name) throws DataAccessException;
}
