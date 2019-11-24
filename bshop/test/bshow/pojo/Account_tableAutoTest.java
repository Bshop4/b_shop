package bshow.pojo;

/**
 * Account_table单元测试
 */
import junit.framework.TestCase;

public class Account_tableAutoTest extends TestCase {
	int num;
	String str;
	private Account_tableTest a_t = null;

	@Override
	public void setUp() throws Exception {
		a_t = new Account_tableTest();
	}

	@Override
	public void tearDown() throws Exception {
		a_t = null;
	}

	public void testGetAccount_id() {
		TestCase.assertEquals(num, a_t.getAccount_id());
	}

	public void testSetAccount_id() {
		TestCase.assertEquals(num, a_t.getAccount_id());
	}

	public void testGetAccount() {
		TestCase.assertEquals(str, a_t.getAccount());
	}

	public void testSetAccount() {
		TestCase.assertEquals(str, a_t.getAccount());
	}

	public void testGetPassword() {
		TestCase.assertEquals(str, a_t.getPassword());
	}

	public void testSetPassword() {
		TestCase.assertEquals(str, a_t.getPassword());
	}

	public void testGetEmail() {
		TestCase.assertEquals(str, a_t.getEmail());
	}

	public void testSetEmail() {
		TestCase.assertEquals(str, a_t.getEmail());
	}

	public void testGetIpaddress() {
		TestCase.assertEquals(str, a_t.getIpaddress());
	}

	public void testSetIpaddress() {
		TestCase.assertEquals(str, a_t.getIpaddress());
	}

	public void testGetBan() {
		TestCase.assertEquals(num, a_t.getBan());
	}

	public void testSetBan() {
		TestCase.assertEquals(num, a_t.getBan());
	}

}

