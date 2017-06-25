package cn.itcast.crm.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.crm.entity.LinkMan;
import cn.itcast.crm.service.LinkManService;

public class LinkManAction extends ActionSupport {

	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	//联系人列表的方法
	public String list() {
		List<LinkMan> list = linkManService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	
}
