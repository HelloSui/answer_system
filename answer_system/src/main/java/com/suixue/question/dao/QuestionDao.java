package com.suixue.question.dao;

import java.util.List;

import com.suixue.common.BaseDao;
import com.suixue.question.domain.Question;
import com.suixue.question.domain.QuestionParam;

public interface QuestionDao extends BaseDao<Question> {

	/**
	 * 查询所有的问题列表
	 * @return
	 */
	List<Question> getList();
	
	/**
	 * 根据参数查询满足条件的问题列表
	 * @param question
	 * @return
	 */
	List<Question> queryQuestionsByParam(QuestionParam question);
	
	/**
	 * 查询附带最好的回答的问题列表
	 * @param question
	 * @return
	 */
	List<Question> getQuestionList(Question question);
	
	/**
	 * 根据问题id进行查询
	 * @param id
	 * @return
	 */
	Question queryQuestionsById(String id);

}
