package com.sera.banking.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


public class AccountInfo {
	// 계좌 정보
	
	private int accountIdx; //계좌 Idx
	private String userName;
	private int userAccount;
	private int balance;
	private float rate;
	@JsonFormat(pattern="yyyy.MM.dd HH:mm:ss")
	private Timestamp createDate;
	
	// 계좌번호 포맷 맞추기 위해 사용
	private String account;
	
	public AccountInfo() {}

	public AccountInfo(int accountIdx, String userName, int userAccount, int balance, float rate, Timestamp createDate) {
		super();
		this.accountIdx = accountIdx;
		this.userName = userName;
		this.userAccount = userAccount;
		this.balance = balance;
		this.rate = rate;
		this.createDate = createDate;
		
	}


	public int getAccountIdx() {
		return accountIdx;
	}

	public void setAccountIdx(int accountIdx) {
		this.accountIdx = accountIdx;
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
		return "AccountInfo [accountIdx=" + accountIdx + ", userName=" + userName + ", userAccount=" + userAccount
				+ ", balance=" + balance + ", rate=" + rate + ", createDate=" + createDate + ", account=" + account
				+ "]";
	}

	
	
	
}
