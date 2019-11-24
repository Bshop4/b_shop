package bshow.dao;

import java.sql.Connection;
import java.util.List;

import bshow.pojo.Account_table;

/**
 * 账号表dao
 * 
 * @author 10415
 *
 */
public interface AccountDao {

	// 添加用户
	public boolean insertAccount(Account_table account, Connection con) throws Exception;

	// 删除用户
	public boolean deleteAccount(Account_table account, Connection con) throws Exception;

	// 更改用户
	public boolean updateAccout(Account_table account, Connection con) throws Exception;

	// 查询所有用户
	public List<Account_table> queryAllAccount(Connection con) throws Exception;

	// 查询单个用户
	public Account_table queryOneAccount(int account_id, Connection con) throws Exception;
}
