package com.suixue.user.dao;

import com.suixue.common.BaseDao;
import com.suixue.user.domain.User;

public interface UserDao extends BaseDao<User>{
	
	//判断数据是否正确
	User validateUser(User param);
	
}
