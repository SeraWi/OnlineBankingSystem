package com.sera.banking.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sera.banking.dao.Dao;
import com.sera.banking.domain.DepositInfo;
import com.sera.banking.domain.TransferInfo;
import com.sera.banking.domain.WithdrawInfo;

@Service
public class HistoryService {
	
	
	private Dao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	// 입금 내역
	public List<DepositInfo> depositInfos(int accountIdx){
		
		return template.getMapper(Dao.class).selectDepositInfo(accountIdx);
	}
	
	// 출금 내역
	public List<WithdrawInfo> withdrawInfos(int accountIdx){
		
		return template.getMapper(Dao.class).selectWithdrawInfo(accountIdx);
	}
	
	
	// 이체 출금
	public List<TransferInfo> transferOut(int accountIdx){
		
		return template.getMapper(Dao.class).selectTransferOut(accountIdx);
	}
	
	// 이체 입금
	public List<TransferInfo> transferIn(int accountIdx){
		
		return template.getMapper(Dao.class).selectTransferIn(accountIdx);
	}
	
}
