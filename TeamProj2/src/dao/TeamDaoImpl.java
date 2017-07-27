package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import model.Player;
import model.Team;

public class TeamDaoImpl extends JdbcDaoSupport implements TeamDao {
	private SimpleJdbcInsert insertTeam;
	
	protected void initDao() throws Exception {
		insertTeam = new SimpleJdbcInsert(getDataSource()).withTableName("team");
	}
	
	public void insertTeam(Team team) throws DataAccessException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("team_id", team.getId());
		parameters.put("name", team.getName());
		insertTeam.execute(parameters);
	}
	@Override
	public List<Team> getTeamList() throws DataAccessException {
		RowMapper<Team> rowMapper = new TeamRowMapper();
		//JdbcDaoSupport의 메소드 getJdbcTemplate 호출
		return getJdbcTemplate().query("select team_id, name from team", rowMapper);
	}
	
	protected class TeamRowMapper implements RowMapper<Team>{
		private List<Team> teamList = new ArrayList<Team>();
		
		public List<Team> getTeamList() {
			return teamList;
		}

		public void setTeamList(List<Team> teamList) {
			this.teamList = teamList;
		}

		//레코드 개수만큼 mapRow가 호출된다.
		public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
			Team team = new Team();
			team.setId(rs.getInt("team_id"));
			team.setName(rs.getString("name"));
			return team;
		}
	}


	

}
