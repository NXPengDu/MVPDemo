package com.nxedu.mvpdemo.model.entity;
/*测试*/
public class UserInfoBean {
	
	private String username;
	private String tel;
	private String nickname;
	private String gender;
	private String usericon;
	
	
	public UserInfoBean() {
		super();
	}


	public UserInfoBean(String username, String tel, String nickname,
			String gender, String usericon) {
		super();
		this.username = username;
		this.tel = tel;
		this.nickname = nickname;
		this.gender = gender;
		this.usericon = usericon;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getUsericon() {
		return usericon;
	}


	public void setUsericon(String usericon) {
		this.usericon = usericon;
	}
	
	
}
