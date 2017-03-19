package com.suixue.common;

import java.sql.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService<T extends DataEntity, D extends BaseDao<T>> {
	@Autowired
	protected D dao;

	public void insert(T entity) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		entity.setId(uuid);
		entity.setCreateTime(new Date(System.currentTimeMillis()));
		entity.setUpdateTime(entity.getCreateTime());
		dao.insert(entity);
	}
	/**
	 * 保存，根据ID来判断是新增还是修改
	 * 
	 * @param entity
	 */
	public void save(T entity) {
		if (entity.getId() == null || entity.getId().equals("")) {
			String uuid = UUID.randomUUID().toString().replace("-", "");
			entity.setId(uuid);
			dao.insert(entity);
		} else {
			entity.setUpdateTime(new Date(System.currentTimeMillis()));
			dao.update(entity);
		}
	}

	public void delete(T entity) {
		dao.delete(entity);
	}

	public void update(T entity) {
		entity.setUpdateTime(new Date(System.currentTimeMillis()));
		dao.update(entity);
	}

	public T get(T entity) {
		return dao.get(entity);
	}
}
