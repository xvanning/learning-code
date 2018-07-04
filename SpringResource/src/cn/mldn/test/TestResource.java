package cn.mldn.test;
import java.util.Iterator;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import cn.mldn.resource.util.ResourceBean;
public class TestResource {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		ResourceBean reb = ctx.getBean("rb",ResourceBean.class);
		Iterator<Resource> iterator = reb.getResource().iterator();
		while (iterator.hasNext()) {
			Scanner scan = new Scanner(iterator.next().getInputStream());
			scan.useDelimiter("\n");
			while (scan.hasNext()) {
				String string = (String) scan.next();
				System.out.println(string);
		}
		System.out.println("*********************************");
		}
	}
}
