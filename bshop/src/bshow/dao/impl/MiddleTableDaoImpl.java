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
		String sql="(select middle_type from middle_table group by middle_type limit ?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, min);
			ps.setInt(2, max);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				list.add(rs.getString("middle_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
