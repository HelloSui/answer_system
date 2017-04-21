package com.suixue.question.service;

import java.util.List;
import com.suixue.question.domain.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.suixue.common.BaseDao;
import com.suixue.common.BaseService;
import com.suixue.question.dao.QuestionDao;
import com.suixue.question.dao.TypeDao;
import com.suixue.question.domain.Question;
import com.suixue.question.domain.QuestionParam;


@Service
public class QuestionService extends BaseService<Question, BaseDao<Question>> {
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private TypeDao typeDao;
	
	public List<Question> getList(){
		return questionDao.getList();
	}
	
	public List<Question> queryQuestionsByParam(QuestionParam question){
		List<Question> questions = questionDao.queryQuestionsByParam(question);
		
		for(Question q : questions) {
			String typeIds = q.getTypeId();
			
			if(!StringUtils.isEmpty(typeIds)){
				List<Type> types = typeDao.queryQuestionTypesByParam(typeIds);
				
				String idTypeString = createIdTypeString(types);
				q.setTypeId(idTypeString.substring(0, idTypeString.length() - 1));
			}
		}
		return questions;
	}	
	
	
	
	private String createIdTypeString(List<Type> types) {
		
		StringBuilder sb = new StringBuilder();
		for(Type type : types) {
			sb.append(type.getId()).append(":").append(type.getDescription()).append(",");
		}
		
		return sb.toString();
	}
	
	public Question queryQuestionsById(String id){
		Question question = questionDao.queryQuestionsById(id);
		return question;
	}
}

