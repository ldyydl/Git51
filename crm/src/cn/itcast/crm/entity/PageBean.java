package cn.itcast.crm.entity;

import java.util.List;

public class PageBean {

	private int currentPage; //当前页
	
	private int totalCount;//总记录数
	//每页记录数
	private int pageSize;
	
	private int totalPage;//总页数
	
	//每页数据list集合
	private List<Customer> list;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}
}
