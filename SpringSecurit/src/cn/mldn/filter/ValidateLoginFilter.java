package cn.mldn.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class ValidateLoginFilter extends UsernamePasswordAuthenticationFilter{
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		//取得输入的验证码
		String code = request.getParameter("code");
		//取得生成的验证码
		String rand = (String) request.getSession().getAttribute("code");
		//此处是找到特定参数的信息，那么都可以在此处验证
		String username = super.obtainUsername(request).trim();
		String password = super.obtainPassword(request).trim();
		System.out.println("【用户名】username: " + username);
		System.out.println("【密   码】password: " + password);
		//进行验证码的验证
		if (code!=null && rand.equalsIgnoreCase(code)) {//验证码正确
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
			return super.getAuthenticationManager().authenticate(token);
		}else {
			//如果有需要也可以继续判断用户名和密码的情况
			throw new AuthenticationServiceException("验证码不正确！");
		}
	}
}
