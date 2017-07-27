package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import model.Player;
import model.Team;

public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao{

	private SimpleJdbcInsert insertPlayer;
	private PlayerListQuery playerListQuery;
	private PlayerQuery playerQuery;
	private UpdatePlayer updatePlayer;
	private DeletePlayer deletePlayer;
	
	protected void initDao() throws Exception {
		insertPlayer = new SimpleJdbcInsert(getDataSource()).withTableName("player");
		playerListQuery = new PlayerListQuery(getDataSource());
		playerQuery = new PlayerQuery(getDataSource());
		updatePlayer = new UpdatePlayer(getDataSource());
		deletePlayer = new DeletePlayer(getDataSource());
	}
	
	public void insertPlayer(Player player) throws DataAccessException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("player_id", player.getId());
		parameters.put("name", player.getName());
		parameters.put("team_id", player.getTeam().getId());
		insertPlayer.execute(parameters);
	}
	
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
	public List<Player> getPlayerList(Integer teamId) throws DataAccessException {
		return this.playerListQuery.execute(teamId);
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
			player.getTeam().setName((rs.getString(3)));
			return player;
		}
	}
	
	class PlayerQuery extends MappingSqlQuery<Player> {
		private final static String sql_player_query = "select player_id, player.name as playerName"
				+ ", team.team_id, team.name as teamName from player, team "
				+ "where player.team_id=team.team_id and player_id=?";
		public PlayerQuery(DataSource ds){
			super(ds, sql_player_query);
			super.declareParameter(new SqlParameter("player_id", Types.INTEGER));
			compile();
		}
		@Override
		protected Player mapRow(ResultSet rs, int arg1) throws SQLException {
			Player player = new Player();
			player.setId(rs.getInt("player_id"));
			player.setName(rs.getString("playerName"));
			Team team = new Team();
			team.setId(rs.getInt("team_id"));
			team.setName(rs.getString("teamName"));
			player.setTeam(team);
			return player;
		}
		
	}
	@Override
	public Player getPlayer(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return playerQuery.findObject(id);
	}
	
	class PlayerListQuery extends MappingSqlQuery<Player> {
		private final static String sql_player_list_query = "select player_id, player.name as playerName, team.team_id, "
				+"team.name as teamName from player, team where player.team_id=team.team_id and "
				+"team.team_id=?";
		public PlayerListQuery(DataSource ds){
			super(ds, sql_player_list_query);
			super .declareParameter(new SqlParameter("team_id", Types.INTEGER)); //쿼리문의 ?에 대해 타입만 지정해서 컴파일 시켜준다.
			compile();
		}
		@Override
		protected Player mapRow(ResultSet rs, int arg1) throws SQLException {
			Player player = new Player();
			player.setId(rs.getInt("player_id"));
			player.setName(rs.getString("playerName"));
			Team team = new Team();
			team.setId(rs.getInt("team_id"));
			team.setName(rs.getString("teamName"));
			player.setTeam(team);
			return player;
		}
		
	}
	@Override
	public void updatePlayer(Player player) throws DataAccessException {
		// TODO Auto-generated method stub
		updatePlayer.update(player.getName(), player.getTeam().getId(), player.getId());
	}
	class UpdatePlayer extends SqlUpdate{
		private static final String sql_update = "update player set name=?, "
				+ "team_id=? where player_id=?";
		public UpdatePlayer(DataSource ds){
			super(ds, sql_update);
			super.declareParameter(new SqlParameter("name", Types.VARCHAR));
			super.declareParameter(new SqlParameter("team_id", Types.INTEGER));
			super.declareParameter(new SqlParameter("player_id", Types.INTEGER));
			compile();
		}
		
	}
	@Override
	public void deletePlayer(Player player) throws DataAccessException {
		// TODO Auto-generated method stub
		deletePlayer.update(player.getId());
	}
	
	class DeletePlayer extends SqlUpdate{
		private final static String sql_delete= "delete from player where player_id=?";
		
		public DeletePlayer(DataSource ds){
			super(ds, sql_delete);
			super.declareParameter(new SqlParameter("player_id", Types.INTEGER));
			compile();			
		}
	}
	
}
