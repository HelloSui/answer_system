package com.suixue.type;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.suixue.question.dao.QuestionDao;
import com.suixue.question.dao.TypeDao;
import com.suixue.question.domain.Question;
import com.suixue.question.domain.Type;
import com.suixue.user.domain.User;

//自动加载spring对应的容器
@ContextConfiguration({"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TypeServiceTest {
	
	@Resource
	private TypeDao typeDao;
	
	@Test
	public void testSelectByParam() {	
		String typeIds = "1,3,5";
		List<Type> result = typeDao.queryQuestionTypesByParam(typeIds);
		for(Type e:result){
			System.out.println(e.toString());
		}
		//userDao.insertUser(user);
	}
	
	@Test
	public void testInsert() {
		
	}
	
	@Test
	public void testUpdate() {
		
	}
	
	@Test
	public void testSelectTypeIds() {
		List<Type> result = typeDao.getList();
		for(Type e:result){
			System.out.println(e.toString());
		}
		//userDao.insertUser(user);
	}
}
