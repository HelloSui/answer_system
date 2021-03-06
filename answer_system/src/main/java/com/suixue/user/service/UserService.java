package com.suixue.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.suixue.base.encrypt.MD5Utils;
import com.suixue.common.BaseDao;
import com.suixue.common.BaseService;
import com.suixue.question.dao.TypeDao;
import com.suixue.question.domain.Question;
import com.suixue.user.dao.UserDao;
import com.suixue.user.domain.User;

@Service
public class UserService extends BaseService<User, BaseDao<User>>{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void insert(User entity) {
		encodePassword(entity);
		super.insert(entity);
	}
	
	
	//使用MD5加密，不可逆
	private void encodePassword(User user) {
		String pwd = user.getPassword();
		user.setPassword(MD5Utils.getMD5(pwd));
	}
	
	@Override
	public User get(User entity) {
		if(!StringUtils.isEmpty(entity.getPassword())){
			encodePassword(entity);
		}
		return super.get(entity);
	}
	
	public User getUserNameById(String userId){
		return userDao.getUserNameById(userId);
	}
	
	
}
