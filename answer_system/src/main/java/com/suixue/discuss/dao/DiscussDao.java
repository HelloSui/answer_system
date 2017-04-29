package com.suixue.discuss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suixue.common.BaseDao;
import com.suixue.discuss.domain.Discuss;

public interface DiscussDao extends BaseDao<Discuss> {

	List<Discuss> getList();
	List<Discuss> queryDiscussesByParam(Discuss discuss);
	public void deleteByQuestionId(@Param("questionId") String questionId);
	
	/**
	 * 查询某个人提出的某个问题的最佳回答
	 * @param discuss
	 * @return
	 */
	Discuss querybestDiscusssByParam(Discuss discuss);
	
	
	/**
	 * 查询某一个问题的回答数量
	 * @param questionId
	 * @return
	 */
	int queryAnswerNum(String questionId);
	
	List<Discuss> queryQuestionIdsOfOneAnswer(String userId);
	
	/**
	 * 该问题是否被回答过
	 * @param questionId
	 * @return
	 */
	List<Discuss> isExistAnswerOfQuestion(String questionId);
	
	List<Discuss> isExistReplyOfAnswer(String discussId);
}
