package com.sera.banking.domain;

import java.sql.Timestamp;

public class DepositHistory {
	private int userAccount;
	private int depositAmount;
	private Timestamp depositDate;
	private String account;
	
	DepositHistory(){}
	
	public DepositHistory(int userAccount, int depositAmount, Timestamp depositDate) {
		super();
		this.userAccount = userAccount;
		this.depositAmount = depositAmount;
		this.depositDate = depositDate;
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

	@Override
	public String toString() {
		return "DepositHistory [userAccount=" + userAccount + ", depositAmount=" + depositAmount + ", depositDate="
				+ depositDate + "]";
	}

	public String getAccount() {
		return String.format("%08d",userAccount);
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	
	
	
}
