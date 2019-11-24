package bshow.pojo;

import java.io.Serializable;

public class Personinfo_tableTest implements Serializable{
	private int personInfo_id;//个人信息主键
	private String nickname;// 昵称
	private String account;//帐号
	private String  photo;//头像
	private String address;//收货地址
	private String sex;//性别
	private String birthday;//生日
	
	public int getPersonInfo_id() {
		return personInfo_id;
	}
	public void setPersonInfo_id(int personInfo_id) {
		this.personInfo_id = personInfo_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	
	
	
	
	
	
	
	

}
