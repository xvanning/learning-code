import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.IMemberService;
import com.pojo.Member;
import junit.framework.TestCase;

public class TestMemberService {
	private static Random rand = new Random() ;
	private static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
	}

	@Test
	public void testAdd() throws Exception {
		Member vo = new Member() ;
		int idx = rand.nextInt(10000) ;
		vo.setMid("mldn - " + idx);
		vo.setName("小李同学 - " + idx);
		vo.setAge(18);
		vo.setBirthday(new Date());
		vo.setSalary(1.1);
		vo.setNote("是个很好的同学！");
		IMemberService service = context.getBean("memberServiceImpl",IMemberService.class) ;
		TestCase.assertTrue(service.add(vo));
	}
	@Test
	public void testSplit() throws Exception {
		IMemberService service = context.getBean("memberServiceImpl",IMemberService.class) ;
		List<Member> all = service.split(null, null, 1, 3) ;
		Logger.getLogger(TestMemberService.class).info(all);
		TestCase.assertTrue(all.size() > 0);
	}
}
