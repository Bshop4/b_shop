package bshow.pojo;

import junit.framework.TestCase;

public class Goods_tableAutoTest extends TestCase {
	int num;
	double db;
	String str;
	private Goods_tableTest g_t = null;

	public void setUp() throws Exception {
		g_t = new Goods_tableTest();
	}

	public void tearDown() throws Exception {
		g_t = null;
	}

	public void testGetGoods_id() {
		TestCase.assertEquals(num, g_t.getGoods_id());
	}

	public void testSetGoods_id() {
		TestCase.assertEquals(num, g_t.getGoods_id());
	}

	public void testGetGoods_name() {
		TestCase.assertEquals(str, g_t.getGoods_name());
	}

	public void testSetGoods_name() {
		TestCase.assertEquals(str, g_t.getGoods_name());
	}

	public void testGetGoods_price() {
		TestCase.assertEquals(db, g_t.getGoods_price());
	}

	public void testSetGoods_price() {
		TestCase.assertEquals(db, g_t.getGoods_price());
	}

	public void testGetGoods_explain() {
		TestCase.assertEquals(str, g_t.getGoods_explain());
	}

	public void testSetGoods_explain() {
		TestCase.assertEquals(str, g_t.getGoods_explain());
	}

	public void testGetGoods_like() {
		TestCase.assertEquals(num, g_t.getGoods_like());
	}

	public void testSetGoods_like() {
		TestCase.assertEquals(num, g_t.getGoods_like());
	}

	public void testGetGoods_photo() {
		TestCase.assertEquals(str, g_t.getGoods_photo());
	}

	public void testSetGoods_photo() {
		TestCase.assertEquals(str, g_t.getGoods_photo());
	}

	public void testGetGoods_category() {
		TestCase.assertEquals(str, g_t.getGoods_category());
	}

	public void testSetGoods_category() {
		TestCase.assertEquals(str, g_t.getGoods_category());
	}

	public void testGetGoods_sex() {
		TestCase.assertEquals(str, g_t.getGoods_sex());
	}

	public void testSetGoods_sex() {
		TestCase.assertEquals(str, g_t.getGoods_sex());
	}

	public void testGetGoods_color() {
		TestCase.assertEquals(str, g_t.getGoods_color());
	}

	public void testSetGoods_color() {
		TestCase.assertEquals(str, g_t.getGoods_color());
	}

	public void testGetGoods_size() {
		TestCase.assertEquals(str, g_t.getGoods_size());
	}

	public void testSetGoods_size() {
		TestCase.assertEquals(str, g_t.getGoods_size());
	}

	public void testGetGoods_explainphoto() {
		TestCase.assertEquals(str, g_t.getGoods_explainphoto());
	}

	public void testSetGoods_explainphoto() {
		TestCase.assertEquals(str, g_t.getGoods_explainphoto());
	}

	public void testGetGoods_discount() {
		TestCase.assertEquals(db, g_t.getGoods_discount());
	}

	public void testSetGoods_discount() {
		TestCase.assertEquals(db, g_t.getGoods_discount());
	}

	public void testGetShop_id() {
		TestCase.assertEquals(num, g_t.getShop_id());
	}

	public void testSetShop_id() {
		TestCase.assertEquals(num, g_t.getShop_id());
	}

	public void testGetGoods_season() {
		TestCase.assertEquals(str, g_t.getGoods_season());
	}

	public void testSetGoods_season() {
		TestCase.assertEquals(str, g_t.getGoods_season());
	}

	public void testGetGoods_uptime() {
		TestCase.assertEquals(str, g_t.getGoods_uptime());
	}

	public void testSetGoods_uptime() {
		TestCase.assertEquals(str, g_t.getGoods_uptime());
	}

	public void testGetGoods_ban() {
		TestCase.assertEquals(str, g_t.getGoods_ban());
	}

	public void testSetGoods_ban() {
		TestCase.assertEquals(str, g_t.getGoods_ban());
	}

}
