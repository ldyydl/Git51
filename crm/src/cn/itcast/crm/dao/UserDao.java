package cn.itcast.crm.dao;

import cn.itcast.crm.entity.User;

public interface UserDao {

	void registerUser(User user);

	User loginUser(User user);

}
