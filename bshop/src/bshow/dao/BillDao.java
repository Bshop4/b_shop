package bshow.dao;

import java.sql.Connection;
import java.util.List;

import bshow.pojo.Bill_table;

/**
 * 订单dao
 * @author 10415
 *
 */
public interface BillDao {
	
	//添加订单
	public boolean insertBill(Bill_table biil, Connection con) throws Exception;
	
	//删除订单
	public boolean deleteBill(Bill_table bill, Connection con) throws Exception;
	
	//更改订单
	public boolean updateBill(Bill_table bill, Connection con) throws Exception;
	
	//根据账号查询订单
	public List<Bill_table> queryBillByAccount(String account,Connection con) throws Exception;
	
	//根据订单编号查询订单
	public List<Bill_table> queryBillByCode(String code,Connection con) throws Exception;
	
}
