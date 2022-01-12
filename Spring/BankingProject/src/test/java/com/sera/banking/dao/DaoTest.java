package com.sera.banking.dao;

import org.apache.ibatis.annotations.Param;

public interface DaoTest {
	
	// 계좌 생성
	int insertAccount(@Param("userName")String userName, @Param("userAccount")int userAccount, @Param("rate")float rate);
}
