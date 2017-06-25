package cn.itcast.crm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.UserDao;
import cn.itcast.crm.entity.User;
import cn.itcast.crm.service.UserService;
import cn.itcast.crm.utils.MD5Utils;

@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//注册
	public void registerUser(User user) {
		//对密码进行MD5加密
		String passwordmd5 = MD5Utils.md5(user.getPassword());
		//放回到user对象里面
		user.setPassword(passwordmd5);
		//调用dao的方法
		userDao.registerUser(user);
	}

	//登录的方法
	public User loginUser(User user) {
		/*
		 * 引入存储的密码是加密的数据，比较密码是否相同
		 * MD5加密特点：不能解密
		 * 把输入的密码进行加密，和数据库存储的加密的密码进行比较
		 * */
		//对密码进行MD5加密
		String passwordmd5 = MD5Utils.md5(user.getPassword());
		//放回到user对象里面
		user.setPassword(passwordmd5);
		return userDao.loginUser(user);
	}
	
}
