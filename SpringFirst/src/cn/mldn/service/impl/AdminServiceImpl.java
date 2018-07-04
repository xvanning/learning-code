package cn.mldn.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dao.IAdminDAO;
import cn.mldn.dao.IRoleDAO;
import cn.mldn.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
	@Resource
	private IAdminDAO adminDAO;
	@Resource
	private IRoleDAO roleDAO;

	@Override
	public boolean login() {
		this.adminDAO.findLogin();
		this.roleDAO.findAll();
		return false;
	}

}
