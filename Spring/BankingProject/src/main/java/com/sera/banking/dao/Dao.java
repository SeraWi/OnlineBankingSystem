package com.sera.banking.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.DepositHistory;
import com.sera.banking.domain.TransferHistory;
import com.sera.banking.domain.WithdrawHistory;

public interface Dao {
	
	
	//1. 계좌번호 중복 체크 
	int selectAccount(@Param("userAccount")int accountNum);
	
	//2. 계좌 생성해서 insert
	int insertAccount(@Param("userName")String userName, @Param("userAccount")int userAccount, @Param("rate")float rate);
		
	//3. 계좌 생성후 계좌 정보 반하ㅗㄴ
	AccountInfo selectAccountInfo(@Param("userAccount")int userAccount);
	
	//4. userName에 해당하는 모든 계좌 정보 반환
	List<AccountInfo> selectAllAccount(@Param("userName")String userName);

	// 5. 입금 후 잔액 update
	void updateAfterDeposit(@Param("userAccount")int userAccount, @Param("depositAmount")int depositAmount);
	
	// 6. 입금 후 입금내역 insert
	void insertDepositInfo(@Param("userAccount")int userAccount, @Param("depositAmount") int depositAmount);
	
	// 7. 출금 후 잔액 update
	void updateAfterWithdrawal(@Param("userAccount")int userAccount, @Param("withdrawalAmount")int withdrawalAmount);

	// 8. 출금 후 출금내역 insert
	void insertWithdrawInfo(@Param("userAccount")int userAccount,@Param("withdrawalAmount") int withdrawalAmount);

	// 9. 입금 내역 select
	List<DepositHistory> selectDepositInfo(int userAccount);
	
	// 10. 출금 내역 select
	List<WithdrawHistory> selectWithdrawInfo(int userAccount);
	
	// 11. 이체 내역 select
	List<TransferHistory> selectTransferInfo(int userAccount);
	
	
	
	
	
	
	
	
}
