package cn.mldn.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.mldn.service.IMemberService;
import cn.mldn.vo.Member;

public class TestMemberService {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IMemberService ser = ctx.getBean("memberServiceImpl",IMemberService.class);
		Member vo = new Member();
		vo.setMid("mldn");
		vo.setName("www.mldn.cn");
		System.out.println(ser.insert(vo));
	}
}
