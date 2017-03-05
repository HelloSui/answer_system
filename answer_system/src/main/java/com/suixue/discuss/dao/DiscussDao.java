package com.suixue.discuss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suixue.common.BaseDao;
import com.suixue.discuss.domain.Discuss;

public interface DiscussDao extends BaseDao<Discuss> {

	List<Discuss> getList();
	List<Discuss> queryDiscussesByParam(Discuss discuss);
	public void deleteByQuestionId(@Param("questionId") String questionId);
}