package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Player;

public interface PlayerDao {
	List<Player> getPlayerList() throws DataAccessException;
	List<Player> getPlayerList(String name) throws DataAccessException;
	List<Player> getPlayerList(Integer teamId) throws DataAccessException;
	public abstract void insertPlayer(Player player) throws DataAccessException;
	Player getPlayer(Integer id) throws DataAccessException;
	void updatePlayer(Player player) throws DataAccessException;
	void deletePlayer(Player player) throws DataAccessException;
}
