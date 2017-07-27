package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import model.Team;

public class TeamDaoImpl extends JdbcDaoSupport implements TeamDao {

	@Override
	public List<Team> getTeamList() throws DataAccessException {
		RowMapper<Team> rowMapper = new TeamRowMapper();
		//JdbcDaoSupport�� �޼ҵ� getJdbcTemplate ȣ��
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

		//���ڵ� ������ŭ mapRow�� ȣ��ȴ�.
		public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
			Team team = new Team();
			team.setId(rs.getInt("team_id"));
			team.setName(rs.getString("name"));
			return team;
		}
	}
	

}
