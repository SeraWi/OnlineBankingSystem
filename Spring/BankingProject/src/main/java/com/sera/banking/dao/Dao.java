package com.sera.banking.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.DepositInfo;
import com.sera.banking.domain.TransferDto;
import com.sera.banking.domain.TransferInfo;
import com.sera.banking.domain.WithdrawInfo;

public interface Dao {
	
	
	// 1. 계좌번호 중복 체크 
	int selectAccount(@Param("userAccount")int accountNum);
	
	// 2. 계좌 생성해서 insert
	int insertAccount(@Param("userIdx")int userIdx, @Param("userName")String userName, @Param("userAccount")int userAccount, @Param("rate")float rate);
		
	// 3. 계좌 한개 정보 반환
	AccountInfo selectAccountInfo(@Param("accountIdx")int accountIdx);
	
	// 4. 계좌 정보 반환 : userAccount로 검색
	AccountInfo selectAccountInfo2(@Param("userAccount")int userAccount);
	
	// 5. 사용자의 모든 계좌 정보 반환
	List<AccountInfo> selectAllAccount(@Param("userIdx")int userIdx);

	// 6. 입금 후 잔액 update (이자계산)
	void updateAfterDeposit(@Param("accountIdx")int accountIdx, @Param("depositAmount")int depositAmount);
	
	// 7. 최근 balance 반환 
	int selectCurrentBalance(@Param("accountIdx")int accountIdx);
	
	// 8. 입금 후 입금내역 insert 
	void insertDepositInfo(@Param("accountIdx")int accountIdx, @Param("depositAmount") int depositAmount, @Param("currentBalance") int currentBalance);
	
	// 9. 출금 후 잔액 update
	void updateAfterWithdrawal(@Param("accountIdx")int accountIdx, @Param("withdrawalAmount")int withdrawalAmount);

	// 10. 출금 후 출금내역 insert
	void insertWithdrawInfo(@Param("accountIdx")int userIdx,@Param("withdrawalAmount") int withdrawalAmount,@Param("currentBalance") int currentBalance);

	// 11. 입금 내역 select
	List<DepositInfo> selectDepositInfo(int accountIdx);
	
	// 12. 출금 내역 select
	List<WithdrawInfo> selectWithdrawInfo(int accountIdx);
	
	// 13. 이체 내역 select (이체출금)
	List<TransferInfo> selectTransferOut(int accountIdx);
	
	// 14. 이체 내역 select (이체 입금 )
	List<TransferInfo> selectTransferIn(int accountIdx);
	
	// 15. userName과 userAccount 해당하는 정보있는지 확인 select(이체)
	int checkAccount(@Param("userAccount")int userAccount, @Param("userName")String userName);

	// 16. Account로 accountIdx 찾기 select
	int getaccountIdx(@Param("userAccount")int userAccount);

	// 17. 이체(입금) 후 잔액 update 
	int updateAfterTransfer(@Param("accountIdx")int toIdx, @Param("transferAmount")int transferAmount);

	// 18. 이체 내역 insert
	void insertTransfer(TransferDto transferDto);
	
	
	
	
	
}
