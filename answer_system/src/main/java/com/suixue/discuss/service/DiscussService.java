package com.suixue.discuss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suixue.common.BaseDao;
import com.suixue.common.BaseService;
import com.suixue.discuss.dao.DiscussDao;
import com.suixue.discuss.domain.Discuss;


@Service
public class DiscussService extends BaseService<Discuss, BaseDao<Discuss>> {
	@Autowired
	private DiscussDao discussDao;
	
	public List<Discuss> getList(){
		return discussDao.getList();
	}
	
	public List<Discuss> queryDiscussesByParam(Discuss discuss){
		return discussDao.queryDiscussesByParam(discuss);
	}
	
	public void deleteByQuestionId(String questionId){
		discussDao.deleteByQuestionId(questionId);
	}
	
	public Discuss  querybestDiscusssByParam(Discuss discuss){
		return discussDao.querybestDiscusssByParam(discuss);
	}
}

