package cn.mldn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.service.IAdminService;
import cn.mldn.service.impl.AdminServiceImpl;
import cn.mldn.vo.Company;

public class TestAdmin {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IAdminService vo = ctx.getBean("adminServiceImpl",AdminServiceImpl.class);
		vo.login();
	}

}
