package com.sera.banking.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sera.banking.dao.Dao;
import com.sera.banking.domain.DepositHistory;
import com.sera.banking.domain.TransferHistory;
import com.sera.banking.domain.WithdrawHistory;

@Service
public class HistoryService {
	
	
	private Dao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	// 입금 내역
	public List<DepositHistory> depositInfos(int userAccount){
		
		return template.getMapper(Dao.class).selectDepositInfo(userAccount);
	}
	
	// 출금 내역
	public List<WithdrawHistory> withdrawInfos(int userAccount){
		
		return template.getMapper(Dao.class).selectWithdrawInfo(userAccount);
	}
	
	
	// 이체 내역 
	public List<TransferHistory> transferInfos(int userAccount){
		
		return template.getMapper(Dao.class).selectTransferInfo(userAccount);
	}
	
}
