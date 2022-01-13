package com.sera.banking.service;


import javax.inject.Inject;


import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sera.banking.dao.Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB_INF/spring/root-context.xml")
class CreateAccountServiceTest {
	
	
	@Autowired
	SqlSessionTemplate template;
	
	@Inject
	Dao dao;
		
	public void Test() {
		System.out.println("실행");
		dao = template.getMapper(Dao.class);
		if(dao!=null) {
			dao.insertAccount("sera", 77235210, 1);
		}else {
			System.out.println("dao null");
		}

	}
	
}
