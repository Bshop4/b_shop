package bshow.dao;

public interface AccountDao {
	public String getNicknameByAccount(String account);
	public int getCartNumberByAccont(String account);
	public int getIsBan(String account);
}
