package cn.mldn.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.mldn.vo.Emp;
public class TestEmp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Emp vo = ctx.getBean("empA",Emp.class);
		System.out.println(vo.toString());
	}

}
