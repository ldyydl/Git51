package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.entity.Customer;
import cn.itcast.crm.entity.Dict;
import cn.itcast.crm.entity.PageBean;

public interface CustomerService {

	List<Dict> listLevel();

	void addCustomer(Customer customer);

	List<Customer> findAll();

	PageBean listpage(int currentPage);

	Customer findOne(int cid);

	void update(Customer customer);

	void delete(Customer customer);

	List<Customer> findCondition(Customer customer);

}
