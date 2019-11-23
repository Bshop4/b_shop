package bshow.dao.impl;

import java.sql.Connection;
import java.util.List;

import bshow.dao.BillDao;
import bshow.pojo.Bill_table;

public class BillDaoImpl implements BillDao{

	@Override
	public boolean insertBill(Bill_table biil, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBill(Bill_table bill, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBill(Bill_table bill, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Bill_table> queryBillByAccount(String account, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill_table> queryBillByCode(String code, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
