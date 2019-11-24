package bshow.pojo;

import junit.framework.TestCase;

public class Shop_tableAutoTest extends TestCase {
	int num;
	private Shop_tableTest s_t = null;

	public void setUp() throws Exception {
		s_t = new Shop_tableTest();
	}

	public void tearDown() throws Exception {
		s_t = null;
	}

	public void testGetShop_id() {
		TestCase.assertEquals(num, s_t.getShop_id());
	}

	public void testSetShop_id() {
		TestCase.assertEquals(num, s_t.getShop_id());
	}

	public void testGetGoods_id() {
		TestCase.assertEquals(num, s_t.getGoods_id());
	}

	public void testSetGoods_id() {
		TestCase.assertEquals(num, s_t.getGoods_id());
	}

}
