package com.sera.banking.domain;

public class TransferDto {
	// 이체 할때
	
	private int toIdx;//받는 사람 Idx
	private int toAccount; //받는 사람 계좌
	private int fromIdx; // 보내는 사람 Idx
	private int transferAmount; //이체액
	private String userName; // 받는 사람 이름
	
	private String toAccount2; 
	

	public TransferDto(){}

	public TransferDto(int toIdx, int toAccount, int fromIdx, int transferAmount, String userName) {
		super();
		this.toIdx = toIdx;
		this.toAccount = toAccount;
		this.fromIdx = fromIdx;
		this.transferAmount = transferAmount;
		this.userName = userName;
	}


	public int getToIdx() {
		return toIdx;
	}

	public void setToIdx(int toIdx) {
		this.toIdx = toIdx;
	}

	public int getToAccount() {
		return toAccount;
	}

	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}

	public int getFromIdx() {
		return fromIdx;
	}

	public void setFromIdx(int fromIdx) {
		this.fromIdx = fromIdx;
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
	
	public String getToAccount2() {
		return String.format("%08d",toAccount);
	}

	public void setToAccount2(String toAccount2) {
		this.toAccount2 = toAccount2;
	}
	
	@Override
	public String toString() {
		return "TransferDto [toIdx=" + toIdx + ", toAccount=" + toAccount + ", fromIdx=" + fromIdx + ", transferAmount="
				+ transferAmount + ", userName=" + userName + "]";
	};
	
	
}
