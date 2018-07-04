package cn.mldn.dao.impl;
import org.springframework.stereotype.Component;

import cn.mldn.dao.IRoleDAO;
@Component
public class RoleDAOImpl implements IRoleDAO {

	@Override
	public boolean findAll() {
		System.out.println("[IRoleDAO] public boolean findAll()");
		return true;
	}

}
