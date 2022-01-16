package com.sera.banking.domain;

import java.sql.Timestamp;

public class WithdrawInfo {
	//출금내역
	
	private int userAccount;
	private int withdrawalAmount;
	private Timestamp withdrawalDate;
	private String account;
	private int currentBalance;
	
	
	public WithdrawInfo() {};
	public WithdrawInfo(int userAccount, int withdrawalAmount, Timestamp withdrawalDate, int currentBalance) {
		super();
		this.userAccount = userAccount;
		this.withdrawalAmount = withdrawalAmount;
		this.withdrawalDate = withdrawalDate;
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
		return "WithdrawInfo [userAccount=" + userAccount + ", withdrawalAmount=" + withdrawalAmount
				+ ", withdrawalDate=" + withdrawalDate + ", account=" + account + ", currentBalance=" + currentBalance
				+ ", getCurrentBalance()=" + getCurrentBalance() + ", getUserAccount()=" + getUserAccount()
				+ ", getWithdrawalAmount()=" + getWithdrawalAmount() + ", getWithdrawalDate()=" + getWithdrawalDate()
				+ ", getAccount()=" + getAccount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
}
