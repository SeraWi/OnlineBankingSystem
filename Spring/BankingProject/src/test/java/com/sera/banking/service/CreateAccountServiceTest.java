package com.sera.banking.service;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.sera.banking.dao.DaoTest;



class CreateAccountServiceTest {
	@Autowired
	SqlSessionTemplate template;
	
	DaoTest dao = template.getMapper(DaoTest.class);
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("beforeclass실행");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("afterclass실행");
	}
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("before실행");
		
		System.out.println("before실행");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	
	@Test
	public void Test() {
		System.out.println("실행");
		
		dao.insertAccount("sera", 77235210, 1);
	}
	
}
