package bshow.dao;

import java.sql.Connection;
import java.util.List;

import bshow.pojo.Personinfo_table;
/**
 * 个人信息dao
 * @author 10415
 *
 */
public interface PersonInfoDao {
	
	//增加个人信息
	public boolean insertPersonInfo(Personinfo_table personInfo,Connection con) throws Exception;
	
	//删除个人信息
	public boolean deletePersonInfo(Personinfo_table personInfo,Connection con) throws Exception;
	
	//更新个人信息
	public boolean updatePersonInfo(Personinfo_table personInfo,Connection con) throws Exception;
	
	//查询所有人的个人信息
	public List<Personinfo_table> queryAllPersonInfo(Connection con) throws Exception;
	
	//查询单个的个人信息
	public Personinfo_table queryOnePersonInfo(String account,Connection con) throws Exception;
	
}	
