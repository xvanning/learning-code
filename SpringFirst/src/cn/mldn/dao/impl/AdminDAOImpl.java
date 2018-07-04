package cn.mldn.dao.impl;
import org.springframework.stereotype.Component;

import cn.mldn.dao.IAdminDAO;
@Component
public class AdminDAOImpl implements IAdminDAO {

	@Override
	public boolean findLogin() {
		System.out.println("[IAdminDAO] public boolean findLogin()");
		return true;
	}

}
