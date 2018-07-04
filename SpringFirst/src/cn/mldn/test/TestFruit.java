package cn.mldn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.demo.Apple;
import cn.mldn.demo.IFruit;
import cn.mldn.vo.Dept;

public class TestFruit {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IFruit fruit = ctx.getBean("apple", Apple.class);
		fruit.eat(); //只关心核心的业务操作方法
		
	}
}
