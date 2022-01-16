package com.sera.banking.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sera.banking.dao.Dao;
import com.sera.banking.domain.AccountInfo;

@Service
public class DepositService {

	/*
	 * 1. 입금한다. 
	 * 2. 내계좌에 돈 update 
	 * 3. 입금내역 insert
	 * 4. 거래 후 잔액 반환한다 select
	 */

	private Dao dao;

	@Autowired
	private SqlSessionTemplate template;

	@Transactional(rollbackFor = Exception.class)
	public void deposit(int accountIdx, int depositAmount) {
		dao = template.getMapper(Dao.class);
		/*
		 * 1. 계좌 잔액 update (입금)
		 * 2. 잔액 update 한 currentBalance 정보
		 * 3. 입금 내역 insert
		 */
		dao.updateAfterDeposit(accountIdx,depositAmount);
		int currentBalance = dao.selectCurrentBalance(accountIdx); 
		dao.insertDepositInfo(accountIdx,depositAmount, currentBalance);

	}
	
	//입금 완료 후 내역 보여주기
	public AccountInfo balanceAfterDeposit(int accountIdx) {
		
		return template.getMapper(Dao.class).selectAccountInfo(accountIdx);
	}
}
