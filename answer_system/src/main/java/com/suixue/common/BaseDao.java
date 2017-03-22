package com.suixue.common;

public interface BaseDao<T> {
	
	public void insert(T entity);

	public void delete(T entity);

	public void update(T entity);

	public T get(T entity);
}
