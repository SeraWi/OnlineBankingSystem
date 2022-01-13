package com.sera.banking.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

public class DaoTestImpl implements DaoTest{
	
	private final String namespace = "com.sera.banking.dao.mapper";
	
	@Inject
	private SqlSession sqlsession;

	@Override
	public int insertAccount(String userName, int userAccount, float rate) {
		return sqlsession.insert(namespace+".insertAccount");
	}

}
