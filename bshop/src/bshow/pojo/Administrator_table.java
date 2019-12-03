package bshow.pojo;

import java.io.Serializable;

public class Administrator_table implements Serializable{
	private int administrator_id;
	private String administrator_account;
	private String sdministrator_password;
	
	
	public int getAdministrator_id() {
		return administrator_id;
	}
	public void setAdministrator_id(int administrator_id) {
		this.administrator_id = administrator_id;
	}
	public String getAdministrator_account() {
		return administrator_account;
	}
	public void setAdministrator_account(String administrator_account) {
		this.administrator_account = administrator_account;
	}
	public String getSdministrator_password() {
		return sdministrator_password;
	}
	public void setSdministrator_password(String sdministrator_password) {
		this.sdministrator_password = sdministrator_password;
	}
	
	
}
