package cn.mldn.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.dao.INewsDAO;
import cn.mldn.vo.News;

public class TestSpring {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		INewsDAO dao = ctx.getBean("INewsDAOImpl",INewsDAO.class);
		News vo = new News();
		vo.setTitle("天气寒冷");
		vo.setContent("今天多注意身体");
		vo.setPubdate(new Date());
		System.out.println(dao.doCreate(vo));
	}

}
