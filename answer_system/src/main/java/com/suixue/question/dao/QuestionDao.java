package com.suixue.question.dao;

import java.util.List;

import com.suixue.common.BaseDao;
import com.suixue.question.domain.Question;
import com.suixue.user.domain.User;

public interface QuestionDao extends BaseDao<User> {

	List<Question> getList();
}
