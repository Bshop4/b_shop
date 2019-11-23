package bshow.dao.impl;

import java.sql.Connection;
import java.util.List;

import bshow.dao.AccountDao;
import bshow.pojo.Account_table;

public class AccountDaoImpl implements AccountDao{

	@Override
	public boolean insertAccount(Account_table account, Connection con) throws Exception {
		
		
		return false;
	}

	@Override
	public boolean deleteAccount(Account_table account, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAccout(Account_table account, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Account_table> queryAllAccount(Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account_table queryOneAccount(String account, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
