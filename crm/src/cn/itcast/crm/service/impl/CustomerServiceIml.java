package cn.itcast.crm.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.entity.Customer;
import cn.itcast.crm.entity.Dict;
import cn.itcast.crm.entity.PageBean;
import cn.itcast.crm.service.CustomerService;
import cn.itcast.crm.utils.Constant;

@Transactional
public class CustomerServiceIml implements CustomerService {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public List<Dict> listLevel() {
		return customerDao.listLevel();
	}

	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	//封装分页数据
	public PageBean listpage(int currentPage) {
		PageBean pageBean = new PageBean();
		//当前页
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = customerDao.findAll().size();
		pageBean.setTotalCount(totalCount);
		//每页记录数
		int pageSize = Constant.PAGESIZE;
		//总页数
		int totalPage = 0;
		//总记录数 / 每页记录数
		if(totalCount%pageSize==0) {
			totalPage = totalCount/pageSize;
		} else {
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//每页数据list集合
		//SELECT * FROM t_customer LIMIT 0,3
		int begin = (currentPage-1)*pageSize;
		List<Customer> list = customerDao.findPageAll(begin,pageSize);
		pageBean.setList(list);
		
//		int size = list.size();
//		for(int i=0;i<size;i++) {
//			list.get(i);
//		}

		return pageBean;
	}

	public Customer findOne(int cid) {
		return customerDao.findOne(cid);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	//条件查询
	public List<Customer> findCondition(Customer customer) {
		List<Customer> list = null;
		//判断是否有条件值
		if(customer.getCustName()!=null && !"".equals(customer.getCustName())) {
			//有条件值
			list = customerDao.findCondition(customer);
		} else {
			//没有条件值，查询所有
			list = customerDao.findAll();
		}
		return list;
	}
	
	
}
