package bshow.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bshow.db.DBhelper;
import bshow.service.AddBill;

public class AddBillImpl implements AddBill {

	@Override
	public boolean AddBill(String id) {
		Connection conn = DBhelper.getConnection();
		String sql = "insert into bill_table (goods_id,goods_photo,goods_name,cart_number,goods_price,allprice,account,goods_color,goods_size,goods_no) select cart_id,cgoods_photo,cgoods_desc,cgoods_number,cgoods_price,cgoods_sub,account,cgoods_color,cgoods_size,cgoods_no from cart_table as ct where ct.cart_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int n = ps.executeUpdate();
			if (n != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBhelper.closeConnection(conn);
		}
		return false;
	}

}
