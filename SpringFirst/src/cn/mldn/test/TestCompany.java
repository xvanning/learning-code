package cn.mldn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.vo.Company;

public class TestCompany {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Company company = ctx.getBean("company",Company.class);
		System.out.println(company.toString());
	}

}
  