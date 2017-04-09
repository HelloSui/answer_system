package com.suixue.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suixue.common.BaseDao;
import com.suixue.common.BaseService;
import com.suixue.question.dao.QuestionDao;
import com.suixue.question.domain.Question;


@Service
public class QuestionService extends BaseService<Question, BaseDao<Question>> {
	@Autowired
	private QuestionDao questionDao;
	
	public List<Question> getList(){
		return questionDao.getList();
	}
	
	public List<Question> queryQuestionsByParam(Question question){
		return questionDao.queryQuestionsByParam(question);
	}	
}

