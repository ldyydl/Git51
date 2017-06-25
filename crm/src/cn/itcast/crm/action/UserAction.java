package cn.itcast.crm.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.entity.User;
import cn.itcast.crm.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	public User getModel() {
		return user;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
		
	//注册
	public String register() {
		//调用service的方法
		userService.registerUser(user);
		
		return "register";
	}

	//登录
	public String login() {
		//使用模型驱动获取表单提交数据
		//调用方法实现登录的操作，查询操作
		User u = userService.loginUser(user);
		//判断
		if(u != null) {
			//登录成功
			//把返回user对象放到session域对象里面
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user", u);
			return "loginsuccess";
		} else {
			//登录失败
			return "login";
		}
	}

	
}
