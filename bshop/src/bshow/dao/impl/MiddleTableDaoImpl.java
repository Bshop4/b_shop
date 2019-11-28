package bshow.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bshow.dao.MiddleTableDao;
import bshow.db.DBhelper;

public class MiddleTableDaoImpl implements MiddleTableDao{

	@Override
	public List<String> selectNav(int min, int max) {
		Connection conn= DBhelper.getConnection();
		List<String> list=new ArrayList<String>();
		String sql="(select middle_type from middle_table group by middle_type)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
//			ps.setInt(1, min);
//			ps.setInt(2, max);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				if(list.size()>9){
					break;
				}
				//长度为2的存进去
				if(rs.getString("middle_type").length()==2&&!rs.getString("middle_type").equals("女装")&&!rs.getString("middle_type").equals("男装")){
					list.add(rs.getString("middle_type"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
