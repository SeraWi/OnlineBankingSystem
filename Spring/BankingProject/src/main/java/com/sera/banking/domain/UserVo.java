package com.sera.banking.domain;

public class UserVo {
	//사용자 정보 세션에 저장
	
	private String userName;
	private int userIdx;
	
	public UserVo(){};
	
	public UserVo(String userName, int userIdx) {
		super();
		this.userName = userName;
		this.userIdx = userIdx;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	@Override
	public String toString() {
		return "UserVo [userName=" + userName + ", userIdx=" + userIdx + "]";
	}
	
	
	
}
