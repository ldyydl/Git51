package cn.itcast.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.crm.dao.LinkManDao;
import cn.itcast.crm.entity.Customer;
import cn.itcast.crm.entity.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	//查询所有联系人
	@SuppressWarnings("all")
	public List<LinkMan> findAll() {
		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}
	

}
