package com.sera.banking.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.DepositInfo;
import com.sera.banking.domain.TransferDto;
import com.sera.banking.domain.TransferInfo;
import com.sera.banking.domain.WithdrawInfo;

public interface Dao {
	
	
	//1. 계좌번호 중복 체크 
	int selectAccount(@Param("userAccount")int accountNum);
	
	//2. 계좌 생성해서 insert
	int insertAccount(@Param("userName")String userName, @Param("userAccount")int userAccount, @Param("rate")float rate);
		
	//3. 계좌 정보 반환
	AccountInfo selectAccountInfo(@Param("userIdx")int userIdx);
	
	//3-1. 계좌 정보 반환 : (userAccount)로 검색
	AccountInfo selectAccountInfo2(@Param("userAccount")int userAccount);
	
	//4. userName에 해당하는 모든 계좌 정보 반환
	List<AccountInfo> selectAllAccount(@Param("userName")String userName);

	// 5. 입금 후 잔액 update
	void updateAfterDeposit(@Param("userIdx")int userIdx, @Param("depositAmount")int depositAmount);
	
	// 6. 입금 후 입금내역 insert
	void insertDepositInfo(@Param("userIdx")int userIdx, @Param("depositAmount") int depositAmount);
	
	// 7. 출금 후 잔액 update
	void updateAfterWithdrawal(@Param("userIdx")int userIdx, @Param("withdrawalAmount")int withdrawalAmount);

	// 8. 출금 후 출금내역 insert
	void insertWithdrawInfo(@Param("userIdx")int userIdx,@Param("withdrawalAmount") int withdrawalAmount);

	// 9. 입금 내역 select
	List<DepositInfo> selectDepositInfo(int userIdx);
	
	// 10. 출금 내역 select
	List<WithdrawInfo> selectWithdrawInfo(int userIdx);
	
	// 11. 이체 내역 select (이체출금)
	List<TransferInfo> selectTransferInfo(int userIdx);
	
	// 11.1 이체 내역 select (이체 입금 ) 돈 받은거
	List<TransferInfo> selectTransferInfo2(int userIdx);
	
	// 12. userName과 userAccount 해당하는 정보있는지 확인 select
	int checkAccount(@Param("userAccount")int userAccount, @Param("userName")String userName);

	//13. Account로 Idx 찾기 select
	int getIdx(@Param("userAccount")int toAccount);

	//14. 이체 잔액 update (입금받은경우)
	int updateAfterTransfer(@Param("userIdx")int toIdx, @Param("transferAmount")int transferAmount);

	//15. 이체 내역 insert
	void insertTransfer(TransferDto transferDto);
	
	
	
	
	
	
	
	
	
}
