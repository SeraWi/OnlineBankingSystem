package com.sera.banking.domain;

import java.sql.Timestamp;

public class DepositInfo {
	//입금 내역 
	
	private int userAccount;
	private int depositAmount;
	private Timestamp depositDate;
	private String account;
	private int currentBalance; // 입금 후 잔액(추가) 
	
	DepositInfo(){}
	
	public DepositInfo(int userAccount, int depositAmount, Timestamp depositDate, int currentBalance) {
		super();
		this.userAccount = userAccount;
		this.depositAmount = depositAmount;
		this.depositDate = depositDate;
		this.currentBalance = currentBalance;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	public int getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(int userAccount) {
		this.userAccount = userAccount;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Timestamp getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(Timestamp depositDate) {
		this.depositDate = depositDate;
	}

	public String getAccount() {
		return String.format("%08d",userAccount);
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "DepositInfo [userAccount=" + userAccount + ", depositAmount=" + depositAmount + ", depositDate="
				+ depositDate + ", account=" + account + ", currentBalance=" + currentBalance + "]";
	}
	
	
}
