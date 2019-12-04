package bshow.pojo;

import java.io.Serializable;

public class Bank implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -190244575203864463L;
	private int id;
	private String account;
	private String pass;
	private double balance;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public Bank() {
		// TODO Auto-generated constructor stub
	}

}
