package com.suixue.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suixue.common.BaseDao;
import com.suixue.common.BaseService;
import com.suixue.question.dao.TypeDao;
import com.suixue.question.domain.Type;


@Service
public class TypeService extends BaseService<Type, BaseDao<Type>> {
	@Autowired
	private TypeDao typeDao;
	
	public List<Type> getList(){
		return typeDao.getList();
	}
	
	public List<Type> queryQuestionTypeIdsByParam(String typeIds){
		 List<Long> typeIdsList = null;
		 String[] arry =typeIds.split(",");
         for (String ids:arry) {
        	 typeIdsList.add(Long.valueOf(ids));
         }
		return typeDao.queryQuestionTypesByParam(typeIdsList);
	}
}

