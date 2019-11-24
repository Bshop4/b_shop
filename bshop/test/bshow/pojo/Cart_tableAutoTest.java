package bshow.pojo;

import junit.framework.TestCase;

public class Cart_tableAutoTest extends TestCase {
	int num;
	double db;
	String str;
	private Cart_tableTest c_t = null;

	public void setUp() throws Exception {
		c_t = new Cart_tableTest();
	}

	public void tearDown() throws Exception {
		c_t = null;
	}

	public void testGetCart_id() {
		TestCase.assertEquals(num, c_t.getCart_id());
	}

	public void testSetCart_id() {
		TestCase.assertEquals(num, c_t.getCart_id());
	}

	public void testGetCart_number() {
		TestCase.assertEquals(num, c_t.getCart_number());
	}

	public void testSetCart_number() {
		TestCase.assertEquals(num, c_t.getCart_number());
	}

	public void testGetGoods_price() {
		TestCase.assertEquals(db, c_t.getGoods_price());
	}

	public void testSetGoods_price() {
		TestCase.assertEquals(db, c_t.getGoods_price());
	}

	public void testGetGoods_explain() {
		TestCase.assertEquals(str, c_t.getGoods_explain());
	}

	public void testSetGoods_explain() {
		TestCase.assertEquals(str, c_t.getGoods_explain());
	}

	public void testGetCart_state() {
		TestCase.assertEquals(num, c_t.getCart_state());
	}

	public void testSetCart_state() {
		TestCase.assertEquals(num, c_t.getCart_state());
	}

}
