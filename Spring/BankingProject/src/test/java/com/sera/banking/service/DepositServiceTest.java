package com.sera.banking.service;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sera.banking.dao.Dao;
import com.sera.banking.dao.DaoTest;


@Service
class DepositServiceTest {
	
	private DaoTest dao;

	@Autowired
	private SqlSessionTemplate template;
	
	@Test
	//@Transactional
	public void deposit(int userAccount, int depositAmount) {
		// 계좌와 입금액을 파라미터로 받는다.
		
		userAccount = 18831361;
		depositAmount = 2000;
		
		dao = template.getMapper(DaoTest.class);
		
		dao.updateAfterDeposit(18831361,2000);
		dao.insertDepositInfo(18831361,2000);
	}

	

}
