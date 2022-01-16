package com.sera.banking.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //Junit으로 테스트
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		) //설정 파일 정보
public class TestCase {
	
	private static final Logger logger = LoggerFactory.getLogger(TestCase.class);
	
	@Inject
	SqlSessionTemplate sqlSession;
	
	@Test
	public void test() {
		
		logger.info("test메서드 실행");
		logger.info("sqlSesssion:" + sqlSession);
	}
}
