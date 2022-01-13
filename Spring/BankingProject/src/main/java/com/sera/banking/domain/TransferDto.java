package com.sera.banking.domain;

public class TransferDto {
	
	
	private int toAccount;
	private int fromAccount;
	private int transferAmount;
	private String userName;
	
	public TransferDto() {}
	
	public TransferDto(int toAccount, int fromAccount, int transferAmount, String userName) {
		super();
		this.toAccount = toAccount;
		this.fromAccount = fromAccount;
		this.transferAmount = transferAmount;
		this.userName = userName;
	}

	public int getToAccount() {
		return toAccount;
	}

	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}

	public int getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}

	public int getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "TransferDto [toAccount=" + toAccount + ", fromAccount=" + fromAccount + ", transferAmount="
				+ transferAmount + ", userName=" + userName + "]";
	}
	
	
}
