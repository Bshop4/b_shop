package bshow.dao.impl;

import java.sql.Connection;
import java.util.List;

import bshow.dao.PersonInfoDao;
import bshow.pojo.Personinfo_table;

public class PersonInfoDaoImpl implements PersonInfoDao{

	@Override
	public boolean insertPersonInfo(Personinfo_table personInfo, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePersonInfo(Personinfo_table personInfo, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePersonInfo(Personinfo_table personInfo, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Personinfo_table> queryAllPersonInfo(Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personinfo_table queryOnePersonInfo(String account, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
