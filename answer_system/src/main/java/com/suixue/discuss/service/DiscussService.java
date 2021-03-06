package com.suixue.discuss.service;

import java.util.ArrayList;
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
	
	public int queryAnswerNum(String questionId){
		int answerNum = 0;
		answerNum = discussDao.queryAnswerNum(questionId);
		return answerNum;
	}
	
	public List<String> queryQuestionIdsOfOneAnswer(String userId){
		List<String> result = new ArrayList<String>();
		List<Discuss> discussOfOne = discussDao.queryQuestionIdsOfOneAnswer(userId);
		for(Discuss d:discussOfOne){
			if(result.isEmpty()){
				result.add(d.getQuestionId());
			}else{
				if(!result.contains(d.getQuestionId())){
					result.add(d.getQuestionId());
				}
			}						
		}
		return result;
	}
	public boolean isExistAnswerOfQuestion(String questionId){
		List<Discuss> result = new ArrayList<>();
		result = discussDao.isExistAnswerOfQuestion(questionId);
		if(result == null){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isExistReplyOfAnswer(String discussId){
		List<Discuss> result = new ArrayList<>();
		result = discussDao.isExistReplyOfAnswer(discussId);
		if(result == null){
			return false;
		}else{
			return true;
		}
	}
	
}

