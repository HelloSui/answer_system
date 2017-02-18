package com.suixue.question.dao;

import java.util.List;

import com.suixue.common.BaseDao;
import com.suixue.question.domain.Question;

public interface QuestionDao extends BaseDao<Question> {

	List<Question> getList();
}
