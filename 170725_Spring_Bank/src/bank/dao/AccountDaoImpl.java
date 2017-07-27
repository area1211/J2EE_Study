package bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import bank.model.Account;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
	private SimpleJdbcInsert insertAccount;
	private AccountQuery accountQuery;
	private UpdateAccount updateAccount;
	//참고시작
//	private PlayerListQuery playerListQuery;
//	private PlayerQuery playerQuery;
//	private UpdatePlayer updatePlayer;
//	private DeletePlayer deletePlayer;
	
	protected void initDao() throws Exception {
		insertAccount = new SimpleJdbcInsert(getDataSource()).withTableName("account");
		accountQuery = new AccountQuery(getDataSource());
		updateAccount = new UpdateAccount(getDataSource());
		//참고시작
//		insertPlayer = new SimpleJdbcInsert(getDataSource()).withTableName("player");
//		playerListQuery = new PlayerListQuery(getDataSource());
//		playerQuery = new PlayerQuery(getDataSource());
//		updatePlayer = new UpdatePlayer(getDataSource());
//		deletePlayer = new DeletePlayer(getDataSource());
	}
	
	//참고끝
	@Override
	public void insertAccount(Account account) throws DataAccessException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("acc_id", account.getId());
		parameters.put("name", account.getName());
		parameters.put("balance", account.getBalance());
		insertAccount.execute(parameters);
		
	}

	@Override
	public List<Account> getAccountList() throws DataAccessException {
		//RowMapper<Account> rowMapper = new AccountRowMapper();
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
		
		List<Account> accountList = getJdbcTemplate().query("select acc_id, name, balance from account", rowMapper);
		
		//System.out.println("**사이즈:"+accountList.size());
		if(accountList.size()==0)
			System.out.println("*** 계좌가 존재하지않습니다. ***");
		
		return accountList;
	}

	@Override
	public Account getAccount(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return accountQuery.findObject(id);
	}
	class AccountQuery extends MappingSqlQuery<Account> {
		private final static String sql_account_query = "select acc_id, name, balance from account where acc_id=?";
		public AccountQuery(DataSource ds){
			super(ds, sql_account_query);
			super.declareParameter(new SqlParameter("acc_id", Types.INTEGER));
			compile();
		}
		@Override
		protected Account mapRow(ResultSet rs, int arg1) throws SQLException {
			Account account = new Account(rs.getInt("acc_id"), rs.getString("name"), rs.getInt("balance"));
			return account;
		}
		
	}
	
	@Override
	public void updateAccount(Account account) throws DataAccessException {
		// TODO Auto-generated method stub
		updateAccount.update(account.getBalance(), account.getId());
	}
	class UpdateAccount extends SqlUpdate{
		private static final String sql_update = "update account set balance=? where acc_id=?";
		public UpdateAccount(DataSource ds){
			super(ds, sql_update);
			super.declareParameter(new SqlParameter("acc_id", Types.INTEGER));
			//super.declareParameter(new SqlParameter("name", Types.VARCHAR));
			super.declareParameter(new SqlParameter("balance", Types.INTEGER));
			compile();
		}
	}
	
	protected class AccountRowMapper implements RowMapper<Account>{
		private List<Account> accountList = new ArrayList<Account>();
		public List<Account> getAccountList() {
			return accountList;
		}
		public void setAccountList(List<Account> accountList) {
			this.accountList = accountList;
		}

		//레코드 개수만큼 mapRow가 호출된다.
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account account = new Account();
			account.setId(rs.getInt("acc_id"));
			account.setName(rs.getString("name"));
			account.setBalance(rs.getInt("balance"));
			return account;
		}
	}
}
