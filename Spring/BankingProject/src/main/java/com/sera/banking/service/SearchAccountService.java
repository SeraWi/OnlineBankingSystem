package com.sera.banking.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sera.banking.dao.Dao;
import com.sera.banking.domain.AccountInfo;

@Service
public class SearchAccountService {
	
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	// 전체 계좌 정보 반환
	public List<AccountInfo> getAllAcountInfo(int userIdx) {
		
		return template.getMapper(Dao.class).selectAllAccount(userIdx);
	}
	
	// 계좌 정보 하나 반환 accountIdx로 검색
	public AccountInfo getOneAccount(int accountIdx) {
		
		return template.getMapper(Dao.class).selectAccountInfo(accountIdx);
	}
	
	// 해당계좌와 이름에 맞는 정보 있는지 확인 (이체할 때 확인)
	public int checkAccount(String userName, int userAccount) {
		
		return template.getMapper(Dao.class).checkAccount(userAccount, userName);
	}
	
}
