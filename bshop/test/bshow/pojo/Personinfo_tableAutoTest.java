package bshow.pojo;

import junit.framework.TestCase;

public class Personinfo_tableAutoTest extends TestCase {
	int num;
	String str;
	private Personinfo_tableTest p_t = null;

	public void setUp() throws Exception {
		p_t = new Personinfo_tableTest();
	}

	public void tearDown() throws Exception {
		p_t = null;
	}

	public void testGetPersonInfo_id() {
		TestCase.assertEquals(num, p_t.getPersonInfo_id());
	}

	public void testSetPersonInfo_id() {
		TestCase.assertEquals(num, p_t.getPersonInfo_id());
	}

	public void testGetNickname() {
		TestCase.assertEquals(str, p_t.getNickname());
	}

	public void testSetNickname() {
		TestCase.assertEquals(str, p_t.getNickname());
	}

	public void testGetAccount() {
		TestCase.assertEquals(str, p_t.getAccount());
	}

	public void testSetAccount() {
		TestCase.assertEquals(str, p_t.getAccount());
	}

	public void testGetPhoto() {
		TestCase.assertEquals(str, p_t.getPhoto());
	}

	public void testSetPhoto() {
		TestCase.assertEquals(str, p_t.getPhoto());
	}

	public void testGetAddress() {
		TestCase.assertEquals(str, p_t.getAddress());
	}

	public void testSetAddress() {
		TestCase.assertEquals(str, p_t.getAddress());
	}

	public void testGetSex() {
		TestCase.assertEquals(str, p_t.getSex());
	}

	public void testSetSex() {
		TestCase.assertEquals(str, p_t.getSex());
	}

	public void testGetBirthday() {
		TestCase.assertEquals(str, p_t.getBirthday());
	}

	public void testSetBirthday() {
		TestCase.assertEquals(str, p_t.getBirthday());
	}

}
