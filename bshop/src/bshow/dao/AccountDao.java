package bshow.dao;

import java.sql.Connection;

import bshow.pojo.Account_table;

public interface AccountDao {
	
	//添加用户
	public boolean insertAccount(Account_table account, Connection con) throws Exception;
	
}
