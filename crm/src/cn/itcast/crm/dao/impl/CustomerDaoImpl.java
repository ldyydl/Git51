package cn.itcast.crm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.entity.Customer;
import cn.itcast.crm.entity.Dict;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	//查询所有级别
	public List<Dict> listLevel() {
		return (List<Dict>) this.getHibernateTemplate().find("from Dict");
	}

	//添加客户
	public void addCustomer(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	//查询所有客户
	public List<Customer> findAll() {
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}

	//查询记录数
	public int findCount() {
//		find
		String hql = "select count(*) from Customer";
		List<Object> list = (List<Object>) this.getHibernateTemplate().find(hql);
		for (Object object : list) {
			Long lobj = (Long) object;
			int count = lobj.intValue();
			return count;
		}
		return 0;
		
//		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
//		
//		criteria.setProjection(Projections.rowCount());
//		
//		List<Object> list = (List<Object>) this.getHibernateTemplate().findByCriteria(criteria);
//		for (Object object : list) {
//			Long lobj = (Long) object;
//			int count = lobj.intValue();
//			return count;
//		}
//		return 0;
		
	}

	//分页查询
	@SuppressWarnings("unchecked")
	public List<Customer> findPageAll(int begin, int pageSize) {
		//find方法，单纯使用find方法不能实现分页的
		//findByCritica方法
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//findByCriteria有三个参数：
		// 第二个参数是开始位置
		// 第三个参数是每页记录数
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
	}

	//根据cid查询
	public Customer findOne(int cid) {
		return this.getHibernateTemplate().get(Customer.class, cid);
	}

	//修改
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

	//删除
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

	//条件查询-hql实现
	@SuppressWarnings("unchecked")
	public List<Customer> findConditionhql(Customer customer) {
		String hql = "from Customer where custName like ?";
		return (List<Customer>) this.getHibernateTemplate().
								find(hql,"%"+customer.getCustName()+"%");
	}

	//条件查询-qbc实现
	@SuppressWarnings("unchecked")
	public List<Customer> findCondition(Customer customer) {
		//离线
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		
		//设置条件参数
		criteria.add(Restrictions.like("custName","%"+customer.getCustName()+"%"));
		
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
	}
	
	//条件查询-hibernate底层代码实现
	@SuppressWarnings("unchecked")
	public List<Customer> findConditionSQL(Customer customer) {
		//获取sessionFactory，获取session对象
		Session session = this.getSessionFactory().getCurrentSession();
		
		session.createSQLQuery("");
		
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.like("custName","%"+customer.getCustName()+"%"));
		return criteria.list();
	}
	
}
