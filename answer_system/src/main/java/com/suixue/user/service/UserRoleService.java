package com.suixue.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suixue.common.BaseDao;
import com.suixue.common.BaseService;
import com.suixue.user.dao.UserDao;
import com.suixue.user.dao.UserRoleDao;
import com.suixue.user.domain.User;
import com.suixue.user.domain.UserRole;

@Service
public class UserRoleService extends BaseService<UserRole, BaseDao<UserRole>>{
	@Autowired
	private UserRoleDao userRoleDao;
	
	public UserRole getUserRole(String userId){
		return userRoleDao.getUserRole(userId);
	}
}
