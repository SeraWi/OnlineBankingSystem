package com.sera.banking.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


public class AccountInfo {
	
	private int userIdx;
	private String userName;
	private int userAccount;
	private int balance;
	private float rate;
	@JsonFormat(pattern="yyyy.MM.dd HH:mm:ss")
	private Timestamp createDate;
	
	// 계좌번호 포맷 맞추기 위해 사용
	private String account;
	
	public AccountInfo() {}

	public AccountInfo(int userIdx, String userName, int userAccount, int balance, float rate, Timestamp createDate) {
		super();
		this.userIdx = userIdx;
		this.userName = userName;
		this.userAccount = userAccount;
		this.balance = balance;
		this.rate = rate;
		this.createDate = createDate;
		
	}

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(int userAccount) {
		this.userAccount = userAccount;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	// 계좌번호 8자리 아래일경우 앞에 0붙여서 반환
	public String getAccount() {
		return String.format("%08d",userAccount);
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "AccountInfo [userIdx=" + userIdx + ", userName=" + userName + ", userAccount=" + userAccount
				+ ", balance=" + balance + ", rate=" + rate + ", createDate=" + createDate + ", account=" + account
				+ "]";
	}
	
	
	
	
	
}
