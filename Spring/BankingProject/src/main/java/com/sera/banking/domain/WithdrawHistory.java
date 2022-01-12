package com.sera.banking.domain;

import java.sql.Timestamp;

public class WithdrawHistory {
	
	private int userAccount;
	private int withdrawalAmount;
	private Timestamp withdrawalDate;
	private String account;
	
	
	public WithdrawHistory() {};
	
	
	public WithdrawHistory(int userAccount, int withdrawalAmount, Timestamp withdrawalDate) {
		super();
		this.userAccount = userAccount;
		this.withdrawalAmount = withdrawalAmount;
		this.withdrawalDate = withdrawalDate;
	}
	public int getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(int userAccount) {
		this.userAccount = userAccount;
	}

	public int getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public void setWithdrawalAmount(int withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}
	public Timestamp getWithdrawalDate() {
		return withdrawalDate;
	}

	public void setWithdrawalDate(Timestamp withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	public String getAccount() {
		return String.format("%08d",userAccount);
	}

	public void setAccount(String account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "WithdrawHistory [userAccount=" + userAccount + ", withdrawalAmount=" + withdrawalAmount
				+ ", withdrawalDate=" + withdrawalDate + ", account=" + account + "]";
	}
	
	
	
}
