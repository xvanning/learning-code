package cn.mldn.eldemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import cn.mldn.vo.Message;
public class TestMessage {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Message message = ctx.getBean("msg",Message.class);
		System.out.println(message.getInfo());
	}
}