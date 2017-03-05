package com.suixue.question.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suixue.common.BaseDao;
import com.suixue.question.domain.Question;

public interface QuestionDao extends BaseDao<Question> {

	List<Question> getList();
	List<Question> queryQuestionsByParam(@Param("question")Question question);
}
