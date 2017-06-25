package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.entity.Customer;
import cn.itcast.crm.entity.Dict;

public interface CustomerDao {

	List<Dict> listLevel();

	void addCustomer(Customer customer);

	List<Customer> findAll();

	int findCount();

	List<Customer> findPageAll(int begin, int pageSize);

	Customer findOne(int cid);

	void update(Customer customer);

	void delete(Customer customer);

	List<Customer> findCondition(Customer customer);

}
