package com.sera.banking.domain;

import java.sql.Timestamp;

public class TransferInfo {
	//이체 내역 조회
	
	
	private int userAccount; 
	private String userName; 
	private int transferAmount; 
	private Timestamp transferDate; 
	
	private String account;
	

	public TransferInfo(){}
	
	public TransferInfo(int userAccount, String userName, int transferAmount, Timestamp transferDate) {
		super();
		this.userAccount = userAccount;
		this.userName = userName;
		this.transferAmount = transferAmount;
		this.transferDate = transferDate;
	}

	public int getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(int userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}

	public Timestamp getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Timestamp transferDate) {
		this.transferDate = transferDate;
	}
	
	
	public String getAccount() {
		return String.format("%08d",userAccount);
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "TransferHistory [userAccount=" + userAccount + ", userName=" + userName + ", transferAmount="
				+ transferAmount + ", transferDate=" + transferDate + "]";
	}
	
	
	
}
