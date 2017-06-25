package cn.itcast.crm.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.LinkManDao;
import cn.itcast.crm.entity.LinkMan;
import cn.itcast.crm.service.LinkManService;

@Transactional
public class LinkManServiceImpl implements LinkManService {

	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	public List<LinkMan> findAll() {
		return linkManDao.findAll();
	}
	
}
