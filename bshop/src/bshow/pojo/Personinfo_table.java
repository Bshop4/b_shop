package bshow.pojo;

import java.io.Serializable;
import java.util.Arrays;

public class Personinfo_table implements Serializable{
	private int personInfo_id;//个人信息主键
	private String nickname;// 昵称
	private String account;//帐号
	private byte[]  photo;//头像
	private String address;//收货地址
	private String sex;//性别
	private String birthday;//生日
//	private String tel;//手机号
//	private String postcode;//邮编
	
	
	
//	@Override
//	public String toString() {
//		return "Personinfo_table [personInfo_id=" + personInfo_id + ", nickname=" + nickname + ", account=" + account
//				+ ", photo=" + Arrays.toString(photo) + ", address=" + address + ", sex=" + sex + ", birthday="
//				+ birthday + ", tel=" + tel + ", postcode=" + postcode + "]";
//	}
//	public String getPostcode() {
//		return postcode;
//	}
//	public void setPostcode(String postcode) {
//		this.postcode = postcode;
//	}
//	public String getTel() {
//		return tel;
//	}
//	public void setTel(String tel) {
//		this.tel = tel;
//	}
	public int getPersonInfo_id() {
		return personInfo_id;
	}
	@Override
	public String toString() {
		return "Personinfo_table [personInfo_id=" + personInfo_id + ", nickname=" + nickname + ", account=" + account
				+ ", photo=" + Arrays.toString(photo) + ", address=" + address + ", sex=" + sex + ", birthday="
				+ birthday + "]";
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
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
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
