package cn.itcast.crm.service;

import cn.itcast.crm.entity.User;

public interface UserService {

	void registerUser(User user);

	User loginUser(User user);

}
