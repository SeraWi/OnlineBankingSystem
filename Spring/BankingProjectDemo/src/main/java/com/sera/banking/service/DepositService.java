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

	//rollback이 안됨!
	@Transactional(rollbackFor = Exception.class)
	public void deposit(int userIdx, int depositAmount) {
		// 계좌와 입금액을 파라미터로 받는다.
		dao = template.getMapper(Dao.class);
		try{
			
			dao.updateAfterDeposit(userIdx,depositAmount);
			dao.insertDepositInfo(userIdx,depositAmount);
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

	
	//searchservice
	public AccountInfo balanceAfterDeposit(int userIdx) {
		//입금 완료 후 내역 보여주기
		dao = template.getMapper(Dao.class);
		AccountInfo info = dao.selectAccountInfo(userIdx);
		return info;
	}
}
