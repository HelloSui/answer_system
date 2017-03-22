package com.suixue.question.dao;

import java.util.List;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suixue.common.BaseDao;
import com.suixue.common.BaseDao;
import com.suixue.question.domain.Type;
import com.suixue.question.domain.Type;

public interface TypeDao extends BaseDao<Type> {

	/**
	 * 查询所有的问题类型列表
	 * @return
	 */
	List<Type> getList();
	List<Type> queryQuestionTypesByParam(@Param("typeIds")String typeIds);
}

