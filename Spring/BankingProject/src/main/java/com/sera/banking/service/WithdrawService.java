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


	// 출금하기 update-> 출금 내역 insert하기
	@Transactional
	public void withdraw(int userAccount, int withdrawalAmount) {
		dao = template.getMapper(Dao.class);

		dao.updateAfterWithdrawal(userAccount, withdrawalAmount);
		dao.insertWithdrawInfo(userAccount, withdrawalAmount);
	}


	public AccountInfo balanceAfterWithdraw(int userAccount) {

		//출금 완료 후 내역 보여주기
		dao = template.getMapper(Dao.class);
		AccountInfo info = dao.selectAccountInfo(userAccount);
		return info;
	}

}
