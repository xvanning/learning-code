package cn.mldn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.demo.Apple;
import cn.mldn.demo.IFruit;
import cn.mldn.vo.Dept;

public class TestDept {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dept vo = ctx.getBean("dept",Dept.class);
		System.out.println(vo.toString());
		
	}
}
