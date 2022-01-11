package com.sera.banking.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sera.banking.domain.AccountInfo;

public interface Dao {
	
	
	//1. 계좌가 있는지 확인하는 메서드
	int selectAccount(@Param("userAccount")int accountNum);
	
	//2. 계좌 생성해서 insert하는 메서드 이름, 계좌번호, 이율
	int insertAccount(@Param("userName")String userName, @Param("userAccount")int userAccount, @Param("rate")float rate);
		
	//3. 계좌 생성후 반환 하는 메서드
	AccountInfo selectAccountInfo(@Param("userAccount")int userAccount);
	
	//4. userName에 해당하는 모든 계좌 정보 반환하는 메서드
	List<AccountInfo> selectAllAccount(@Param("userName")String userName);

	// 5. 입금 후 잔액 update
	void updateAfterDeposit(@Param("userAccount")int userAccount, @Param("depositAmount")int depositAmount);
	
	// 6. 입금 후 입금내역 insert
	void insertDepositInfo(@Param("userAccount")int userAccount, @Param("depositAmount") int depositAmount);
	
	
	
	
}
