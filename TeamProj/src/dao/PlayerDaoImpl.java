package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import model.Player;

public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao{

	@Override
	public List<Player> getPlayerList() throws DataAccessException {
		RowMapper<Player> rowMapper = new PlayerRowMapper();
		
		List<Player> playerList = getJdbcTemplate().query("select player_id, name, team_id from player", rowMapper);
		
		System.out.println("**사이즈:"+playerList.size());
		if(playerList.size()==0)
			System.out.println("*** 선수 목록이 존재하지않습니다. ***");
		
		return playerList; 
		
	}
	public List<Player> getPlayerList(String team_name) throws DataAccessException {
		RowMapper<Player> rowMapper = new PlayerRowMapper();
	
		
		return getJdbcTemplate().query("select player_id, player.name, team.name "
				+ "from player left join team on player.team_id=team.team_id "
				+ "where team.name=\'"+team_name+"\' order by player_id", rowMapper);
		
	}
	
	protected class PlayerRowMapper implements RowMapper<Player>{
		private List<Player> playerList = new ArrayList<Player>();
		
		
		public List<Player> getPlayerList() {
			return playerList;
		}
		public void setPlayerList(List<Player> playerList) {
			this.playerList = playerList;
		}



		//레코드 개수만큼 mapRow가 호출된다.
		public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
			Player player = new Player();
			player.setId(rs.getInt(1));
			player.setName(rs.getString(2));
			//player.setTeam_id(rs.getInt("team_id"));
			player.setTeam_name(rs.getString(3));
			return player;
		}
	}

}
