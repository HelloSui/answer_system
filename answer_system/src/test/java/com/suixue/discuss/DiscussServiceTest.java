package com.suixue.discuss;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.suixue.discuss.dao.DiscussDao;
import com.suixue.discuss.domain.Discuss;

//自动加载spring对应的容器
@ContextConfiguration({"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DiscussServiceTest {
	
	@Resource
	private DiscussDao discussDao;
	
	@Test
	public void testSelect() {
		List<Discuss> result = discussDao.getList();
		for(Discuss e:result){
			System.out.println(e.toString());
		}
		//userDao.insertUser(user);
	}
	
	@Test
	public void testSelectByParam() {	
		Discuss discuss = new Discuss();
		discuss.setId("3");
//		discuss.setQuestionId("3");
//		discuss.setListnerId("2");
//		discuss.setSpeakerId("3");
		//discuss.setContent("试试");
	
		List<Discuss> result = discussDao.queryDiscussesByParam(discuss);
		for(Discuss e:result){
			System.out.println(e.toString());
		}
		//userDao.insertUser(user);
	}
	
	@Test
	public void testInsert() {
		Discuss discuss = new Discuss();
		//discuss.setId("1");
		discuss.setQuestionId("2");
		discuss.setListnerId("2");
		discuss.setSpeakerId("3");
		discuss.setContent("dsafhiusahdfashifu");
		discussDao.insert(discuss);
	}
	
	@Test
	public void testUpdate() {
		Discuss discuss = new Discuss();
		discuss.setId("2");
		discuss.setQuestionId("3");
		discuss.setListnerId("1");
		discuss.setSpeakerId("1");
		discuss.setContent("试试");
		discussDao.update(discuss);
	}
	
	@Test
	public void testDelect() {
		Discuss discuss = new Discuss();
		//discuss.setId("5");
		discuss.setQuestionId("2");
		discussDao.delete(discuss);
	}
	
	@Test
	public void testDelectByParam() {
		discussDao.deleteByQuestionId("2");
	}
	@Test
	public void querybestDiscusssByParam() {
		Discuss discuss = new Discuss();
		discuss.setQuestionId("3");
		discuss.setListnerId("4");
		Discuss result = discussDao.querybestDiscusssByParam(discuss);
		if(result == null){
			System.out.println("null");
		}
		System.out.println(result.toString());
	}
}
