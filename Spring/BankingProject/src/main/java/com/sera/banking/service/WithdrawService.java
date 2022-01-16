package com.sera.banking.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sera.banking.dao.Dao;
import com.sera.banking.domain.AccountInfo;

@Service
public class WithdrawService {


	/*
	 * 1.출금하고 내계좌에 돈 update
	 * 2.출금 내역 insert 
	 * 3.거래 후 잔액 반환 select
	 */

	private Dao dao;

	@Autowired
	private SqlSessionTemplate template;


	@Transactional(rollbackFor = Exception.class)
	public void withdraw(int accountIdx, int withdrawalAmount) {
		dao = template.getMapper(Dao.class);
		
		/*
		 * 1. 출금하기, 잔액 update 
		 * 2. 출금 후 잔액 반환  
		 * 3. 출금 내역에 insert
		 */
		
		dao.updateAfterWithdrawal(accountIdx, withdrawalAmount);
		int currentBalance = dao.selectCurrentBalance(accountIdx);
		dao.insertWithdrawInfo(accountIdx, withdrawalAmount,currentBalance);
	}

	// 출금 완료 후 정보 반환
	public AccountInfo balanceAfterWithdraw(int accountIdx) {
		
		return template.getMapper(Dao.class).selectAccountInfo(accountIdx);
	}

}
