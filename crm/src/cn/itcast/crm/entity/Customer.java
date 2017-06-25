package cn.itcast.crm.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer cid;
	private String custName;
	private String custSource;
	private String custPhone;
	private String custMobile;
	private String custAddress;
	private String custZip;
	
	//表示客户里面所有联系人
	private Set<LinkMan> setLinkMan = new HashSet<LinkMan>();
	public Set<LinkMan> getSetLinkMan() {
		return setLinkMan;
	}
	public void setSetLinkMan(Set<LinkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
	}
	//客户所属级别，使用对象
	private Dict dict;
	public Dict getDict() {
		return dict;
	}
	public void setDict(Dict dict) {
		this.dict = dict;
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustZip() {
		return custZip;
	}
	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}
}
