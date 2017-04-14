package com.suixue.user.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.suixue.user.domain.User;
import com.suixue.user.domain.UserRole;

//自动加载spring对应的容器
@ContextConfiguration({"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
	
	@Resource
	private UserDao userDao;
	@Resource
	private UserRoleDao userRoleDao;
	
	@Test
	public void testInsertUser() {
		User user = new User();
		user.setId("1");
		user.setName("zhangsan");
		user.setPassword("123489");
		
		userDao.insert(user);
	}
	
	@Test
	public void testSelectUser() {		
		User user = userDao.getUserNameById("4");
		System.out.println(user.getName());
	}
	@Test
	public void testSelectUserRole() {		
		UserRole user = userRoleDao.getUserRole("4");
		System.out.println(user.getRoleId());
	}
}
