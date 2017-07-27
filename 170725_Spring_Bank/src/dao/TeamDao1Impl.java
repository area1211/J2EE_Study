package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import model.Team;

public class TeamDao1Impl extends NamedParameterJdbcDaoSupport implements TeamDao1 {
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
	public Team getTeam(Integer teamId) throws DataAccessException {
		final String sql = "select team_id, name from team where team_id=:teamId";//콜론(:) 뒤에 문자열이 파라미터로 받은 인자의 문자열과 같아야한다.
		SqlParameterSource parameterSource = new MapSqlParameterSource("teamId", teamId);
		return getNamedParameterJdbcTemplate().query(sql, parameterSource, new TeamResultSetExtractor());
	}
	
	protected class TeamResultSetExtractor implements ResultSetExtractor<Team> {

		@Override
		public Team extractData(ResultSet rs) throws SQLException, DataAccessException {
			Team team=null;
			if(rs.next()){
				team = new Team();
				team.setId(rs.getInt("team_id"));
				team.setName(rs.getString("name"));
				
			}
			
			return team;
		}
		
		
	}

}
