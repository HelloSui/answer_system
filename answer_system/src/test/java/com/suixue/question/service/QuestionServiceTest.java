package com.suixue.question.service;

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
public class QuestionServiceTest {
	
	@Resource
	private QuestionDao questionDao;
	@Resource
	private TypeDao typeDao;
	
	@Test
	public void testSelect() {
		List<Question> result = questionDao.getList();
		for(Question e:result){
			System.out.println(e.toString());
		}
		//userDao.insertUser(user);
	}
	
	@Test
	public void testSelectByParam() {	
		Question question = new Question();
		question.setId("2");
		//question.setDescription("da");
		//question.setTitle("suixueefa");
		//question.setCreateUserId("3");
		//question.setTypeId("3");
		List<Question> result = questionDao.queryQuestionsByParam(question);
		for(Question e:result){
			System.out.println(e.toString());
		}
		//userDao.insertUser(user);
	}
	
	@Test
	public void testInsert() {
		Question question = new Question();
		//question.setId("6");
		question.setDescription("test34");
		question.setTitle("suixueefa");
		question.setCreateUserId("3");
		question.setTypeId("4");
		questionDao.insert(question);
	}
	
	@Test
	public void testUpdate() {
		Question question = new Question();
		question.setId("2");
		question.setDescription("update");
		question.setTitle("suixueya");
		question.setCreateUserId("2");
		question.setTypeId("3");
		questionDao.update(question);
	}
	
	@Test
	public void testDelect() {
		Question question = new Question();
		question.setId("3");
		questionDao.delete(question);
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
