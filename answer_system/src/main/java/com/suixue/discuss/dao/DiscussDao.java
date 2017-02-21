package com.suixue.discuss.dao;

import java.util.List;

import com.suixue.common.BaseDao;
import com.suixue.discuss.domain.Discuss;

public interface DiscussDao extends BaseDao<Discuss> {

	List<Discuss> getList();
	List<Discuss> queryDiscussesByParam(Discuss discuss);
}
