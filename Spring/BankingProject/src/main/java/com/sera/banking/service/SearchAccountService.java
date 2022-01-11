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
	
	public List<AccountInfo> getAllAcountInfo(String userName) {
		List<AccountInfo> allAccountInfo = null;
		dao= template.getMapper(Dao.class);
		allAccountInfo = dao.selectAllAccount(userName);
		
		return allAccountInfo;
	}

}
