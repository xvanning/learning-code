package cn.mldn.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import cn.mldn.vo.Member;

@Component
@Aspect
public class ServiceAspect {
	@Before(value="execution(* cn.mldn..*.*(..))")
	public void serviceBefore() {
		System.out.println("[AOP切面] 执行日志记录操作");
	}
	@Before(value="execution(* cn.mldn..*.*(..)) and args(param)", argNames="param")
	public void serviceBefore2(Object arg) {
		System.out.println("[AOP切面] 执行日志记录操作。参数 = " + arg );
	}
	public void serviceAfter() {
		System.out.println("[AOP切面] 执行事务处理操作");
	}
	public void serviceAfterReturning(Object val) {//表示操作结果
		System.out.println("[AOP切面]操作完成，返回结果： " + val);
	}
	public void serviceAfterThrowing(Exception exp) {//表示操作结果
		System.out.println("[AOP切面]操作出现异常，返回结果： " + exp);
	}
	@Around(value="execution(* cn.mldn..*.*(..))")
	public Object serviceAround(ProceedingJoinPoint point) throws Throwable{
		System.out.println("[AOP切面]数据层方法调用之前，参数： " + Arrays.toString(point.getArgs()));
		Member vo = new Member();
		vo.setMid("xan");
		vo.setName("玩游戏");
		Object retVal = point.proceed(new Object[] { vo });//调用具体的真实操作
		System.out.println("[AOP切面]数据层方法调用之后，返回值： " + retVal);
		return true; //可以自己修改返回值
	}
	
}
