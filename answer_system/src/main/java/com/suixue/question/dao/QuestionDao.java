package com.suixue.question.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suixue.common.BaseDao;
import com.suixue.question.domain.Question;

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
	List<Question> queryQuestionsByParam(@Param("question")Question question);
}
