package com.suixue.common;

import java.util.List;

public class Page<T>{
	
	private int pageNo = 1;
	
	private int pageSize = 10;
	
	private long totalSize;
	
	
	private boolean isFirstPage;
	
	private boolean isLastPage;
	
	private List<T> pageData;

	public int getPageNo() {
		return pageNo;
		
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}

	public int getNextPage() {
		if(!isLastPage()) {
			return pageNo +1 ;
		}
		return pageNo;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public boolean isFirstPage() {
		return pageNo == 1 ? true : false;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	
	/**
	 * 表示当前页是否最后一页
	 * @return
	 */
	public boolean isLastPage() {
		int num = (int) (totalSize/pageSize);
		if(totalSize % pageSize != 0) {
			num++;
		}
		
		return num == pageNo;
	}
	

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		int pageNo = ((com.github.pagehelper.Page<T>) pageData).getPageNum();
		int pageSize= ((com.github.pagehelper.Page<T>) pageData).getPageSize();
		long totalSize = ((com.github.pagehelper.Page<T>) pageData).getTotal();
		
		setPageNo(pageNo);
		setPageSize(pageSize);
		setTotalSize(totalSize);
		
		this.pageData = pageData;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}  
	
}
