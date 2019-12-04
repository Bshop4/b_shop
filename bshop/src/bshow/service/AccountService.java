package bshow.service;

import java.util.List;

import bshow.pojo.Account_table;

public interface AccountService {
	public List<Account_table> selectPage(int PageNo,int PageSize,String account,String email);
	public int selectMaxPage(int PageNo,int PageSize,String account,String email);
}
