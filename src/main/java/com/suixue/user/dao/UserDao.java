package com.suixue.user.dao;

import com.suixue.user.domain.User;

public interface UserDao {
	
	//注册一个用户
	void insertUser(User user);
	//判断数据是否正确
	User validateUser(String name,String password);
}
