package com.sera.banking.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sera.banking.dao.Dao;
import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.TransferDto;

@Service
public class TransferService {
	
	private final static Logger logger = LoggerFactory.getLogger(TransferService.class);
	
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	// 이체하기
	@Transactional(rollbackFor = Exception.class)
	public AccountInfo transfer(TransferDto transferDto) {
		/*
		 * 1. 잔액 update 
		 * 2. 이체 내역에 insert
		 * 3. 이체 후 정보 반환 
		 */
		
		dao = template.getMapper(Dao.class);
		//ToAccount 에 해당하는 toIdx찾기
		int toIdx = dao.getaccountIdx(transferDto.getToAccount());
		// toIdx 세팅
		transferDto.setToIdx(toIdx);
		
		// 잔액 변경, 이체 후 잔액 반환, 이제 내역 저장
		dao.updateAfterWithdrawal(transferDto.getFromIdx(), transferDto.getTransferAmount());	
		dao.updateAfterTransfer(toIdx, transferDto.getTransferAmount());
		dao.insertTransfer(transferDto);
		
		// 이체 완료 후 정보 반환
		return dao.selectAccountInfo(transferDto.getFromIdx());
	}
	
	
}
