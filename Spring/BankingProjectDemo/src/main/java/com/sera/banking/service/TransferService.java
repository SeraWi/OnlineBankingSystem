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
	@Transactional
	public AccountInfo transfer(TransferDto transferDto) {
		/*
		 * 1. toAccount의 toIdx찾기
		 * 2. 잔액 update
		 * 3. 이체 내역에 insert하기 
		 */
		
		dao = template.getMapper(Dao.class);
		//ToAccount 에 해당하는 toIdx찾기
		int toIdx = dao.getIdx(transferDto.getToAccount());
		transferDto.setToIdx(toIdx);
		System.out.println(transferDto.toString());
		
		// 이체한 사람	잔액 마이너스					이체한 사람 Idx	      , 			이체액
		dao.updateAfterWithdrawal(transferDto.getFromIdx(), transferDto.getTransferAmount());	
		logger.info("이체한사람");
		// 이체 당한 사람 잔액 플러스
		dao.updateAfterTransfer(toIdx, transferDto.getTransferAmount());
		logger.info("이체당한 사람");
		// 이체 내역 insert
		dao.insertTransfer(transferDto);
		
		// 이체 완료 후 정보 반환
		return dao.selectAccountInfo(transferDto.getFromIdx());
		
		
	}
	
	
	
}
