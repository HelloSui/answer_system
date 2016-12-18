package com.suixue.user.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.suixue.user.domain.User;

//自动加载spring对应的容器
@ContextConfiguration({"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
	
	@Resource
	private UserDao userDao;
	
	@Test
	public void testInsertUser() {
		User user = new User();
		user.setId("1");
		user.setName("zhangsan");
		user.setPassword("123489");
		
		userDao.insertUser(user);
	}
}
