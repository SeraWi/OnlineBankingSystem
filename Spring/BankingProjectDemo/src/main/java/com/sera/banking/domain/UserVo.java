package com.sera.banking.domain;

public class UserVo {
	// 사용자 이름 - 동명이인 없다
	private String userName;
	
	public UserVo(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserVo [userName=" + userName + "]";
	}
	
	
	
}
