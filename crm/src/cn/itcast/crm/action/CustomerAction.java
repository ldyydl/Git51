package cn.itcast.crm.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.entity.Customer;
import cn.itcast.crm.entity.Dict;
import cn.itcast.crm.entity.PageBean;
import cn.itcast.crm.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private Customer customer = new Customer();
	public Customer getModel() {
		return customer;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//条件查询的方法
	public String findCondition() {
		//使用模型驱动获取提交条件值
		List<Customer> list = customerService.findCondition(customer);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	
	//删除的方法
	public String delete() {
		//判断
		//1 根据id查询客户
		//获取修改客户cid值
		int cid = customer.getCid();
		//根据id查询
		Customer cus = customerService.findOne(cid);
		if(cus != null) {
			//使用模型驱动获取删除客户id值
			customerService.delete(cus);
		}
		return "tolist";
	}
	
	//修改客户方法
	public String updateCustomer() {
		//使用模型驱动获取表单提交数据
		customerService.update(customer);
		return "tolist";
	}
	
	//到修改页面
	public String toUpdatePage() {
		//获取修改客户cid值
		int cid = customer.getCid();
		//根据id查询
		Customer cus = customerService.findOne(cid);
		
		//查询所有级别list集合
		List<Dict> listdict = customerService.listLevel();
		
		//放到域对象
		ServletActionContext.getRequest().setAttribute("customer", cus);
		ServletActionContext.getRequest().setAttribute("listdict", listdict);
		return "toUpdatePage";
	}
	
	
	//使用属性封装获取当前页
	private int currentPage;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	//分页客户列表
	public String listpage() {
		//封装分页数据到pagebean里面
		PageBean pageBean = customerService.listpage(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listpage";
	}
	
	//客户列表的方法
	public String list() {
		List<Customer> list = customerService.findAll();
		//把list放到域对象里面
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	
	//1 在action定义两个变量
	//代表上传文件 ，命名特点：和表单输入项文件上传name属性值一样
	private File upload;
	//代表上传文件名称，命名特点：文件上传name属性值+FileName
	private String uploadFileName;
	//2 生成变量get和set方法
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	//添加客户的方法
	public String addCustomer() throws IOException {
		//复杂方式
//		String id = ServletActionContext.getRequest().getParameter("id");
//		//把id放到customer对象里面dict对象里面
//		Dict dict = new Dict();
//		dict.setDict_id(Integer.parseInt(id));
//		customer.setDict(dict);
		
		//上传逻辑
		//判断是否需要上传文件
		if(upload != null) {
			//1 在上传服务器文件夹里面创建文件（上传文件名称一样）
			File serverFile = new File("I:\\51"+"/"+uploadFileName);
			//2把本地文件复制到服务器文件中
			FileUtils.copyFile(upload, serverFile);
		}
		
		//调用方法实现添加
		customerService.addCustomer(customer);
		return "addCustomer";
	}
	

	//通过查询返回所有级别，json数据格式
	public String listLevel() throws IOException {
		//查询所有级别，返回list集合
		List<Dict> listdict = customerService.listLevel();
		
		//把返回所有级别list转换json数据
		//jsonlib，使用另外一种方式 fastjson转换
		String json = JSON.toJSONString(listdict);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		//设置response返回中文乱码，返回json数据
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		return NONE;
	}
	
	//到添加页面
	public String toAddPage() {
		return "toAddPage";
	}


	
}
