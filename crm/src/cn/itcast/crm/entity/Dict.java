package cn.itcast.crm.entity;

import java.util.HashSet;
import java.util.Set;

public class Dict {

	private Integer dict_id;
	private String dict_name;
	private String dict_type;
	
	//一个级别有很多客户，使用set集合
//	private Set<Customer> setCustomer = new HashSet<Customer>();
//	
//	public Set<Customer> getSetCustomer() {
//		return setCustomer;
//	}
//	public void setSetCustomer(Set<Customer> setCustomer) {
//		this.setCustomer = setCustomer;
//	}
	
	public Integer getDict_id() {
		return dict_id;
	}
	public void setDict_id(Integer dict_id) {
		this.dict_id = dict_id;
	}
	public String getDict_name() {
		return dict_name;
	}
	public void setDict_name(String dict_name) {
		this.dict_name = dict_name;
	}
	public String getDict_type() {
		return dict_type;
	}
	public void setDict_type(String dict_type) {
		this.dict_type = dict_type;
	}
}
