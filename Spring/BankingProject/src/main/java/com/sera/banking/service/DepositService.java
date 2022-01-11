package com.sera.banking.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sera.banking.dao.Dao;

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
	public void deposit(int userAccount, int depositAmount) {
		// 계좌와 입금액을 파라미터로 받는다.
		dao = template.getMapper(Dao.class);
		
		try {
			dao.insertDepositInfo(userAccount,depositAmount);
			if(depositAmount == 2001) {
				dao.updateAfterDeposit(userAccount,depositAmount);
				
			}else {
				throw new Exception();
			}
			
			
		}catch(Exception e) {
			
		}
		
		// 입금내역에 insert



	}


	public int balanceAfterDeposit() {


		return 0;
	}
}
