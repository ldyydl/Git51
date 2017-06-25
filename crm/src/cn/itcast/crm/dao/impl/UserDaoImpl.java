package cn.itcast.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.crm.dao.UserDao;
import cn.itcast.crm.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao  {

	//注册 添加用户的方法
	public void registerUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	//登录的方法
	//根据用户名和密码进行查询操作
	@SuppressWarnings("all")
	public User loginUser(User user) {
		//使用hibernateTemplate做查询操作，使用find
		//find方法对hql进行封装
		String hql = "from User where username=? and password=?";
		//find方法中第一个参数是hql语句，第二个参数是语句中？条件值
		List<User> list = 
				(List<User>) this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword());
		//返回user对象
		//判断list集合是否有值
		if(list.size()>0) {
			User u = list.get(0);
			return u;
		}
		return null;
	}

}
