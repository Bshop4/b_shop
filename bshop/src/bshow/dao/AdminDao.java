package bshow.dao;

import bshow.web.servlet.form.UpdateMyAccountForm;

public interface AdminDao {
	public int selectAccount(String account);
	public boolean doLogin(String account,String password);
	public boolean updateAccountByAdmin(UpdateMyAccountForm form);
	public int deleteMyAccountByAdmin(String account);
}
