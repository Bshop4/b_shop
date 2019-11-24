package bshow.pojo;

import junit.framework.TestCase;

public class Bill_tableAutoTest extends TestCase {
	int num;
	double db;
	String str;
	private Bill_tableTest b_t = null;

	@Override
	public void setUp() throws Exception {
		b_t = new Bill_tableTest();
	}

	@Override
	public void tearDown() throws Exception {
		b_t = null;
	}

	public void testGetBill_id() {
		TestCase.assertEquals(num, b_t.getBill_id());
	}

	public void testSetBill_id() {
		TestCase.assertEquals(num, b_t.getBill_id());
	}

	public void testGetAddress() {
		TestCase.assertEquals(str, b_t.getAddress());
	}

	public void testSetAddress() {
		TestCase.assertEquals(str, b_t.getAddress());
	}

	public void testGetBill_time() {
		TestCase.assertEquals(str, b_t.getBill_time());
	}

	public void testSetBill_time() {
		TestCase.assertEquals(str, b_t.getBill_time());
	}

	public void testGetAllprice() {
		TestCase.assertEquals(db, b_t.getAllprice());
	}

	public void testSetAllprice() {
		TestCase.assertEquals(db, b_t.getAllprice());
	}

	public void testGetAccount() {
		TestCase.assertEquals(str, b_t.getAccount());
	}

	public void testSetAccount() {
		TestCase.assertEquals(str, b_t.getAccount());
	}

	public void testGetGoods_name() {
		TestCase.assertEquals(str, b_t.getGoods_name());
	}

	public void testSetGoods_name() {
		TestCase.assertEquals(str, b_t.getGoods_name());
	}

	public void testGetGoods_price() {
		TestCase.assertEquals(db, b_t.getGoods_price());
	}

	public void testSetGoods_price() {
		TestCase.assertEquals(db, b_t.getGoods_price());
	}

	public void testGetCart_number() {
		TestCase.assertEquals(num, b_t.getCart_number());
	}

	public void testSetCart_number() {
		TestCase.assertEquals(num, b_t.getCart_number());
	}

	public void testGetBill_code() {
		TestCase.assertEquals(str, b_t.getBill_code());
	}

	public void testSetBill_code() {
		TestCase.assertEquals(str, b_t.getBill_code());
	}

}
