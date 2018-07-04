package cn.mldn.vote;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class IPAddressVote implements AccessDecisionVoter<Object> {

	@Override
	public boolean supports(ConfigAttribute attribute) {//进行程序判断,取得IP地址,判断是否支持投票操作
		return attribute.getAttribute() != null && attribute.getAttribute().startsWith("IP_"); //有一个属性是IP_LOCAL_HOST 
 	}

	@Override
	public boolean supports(Class<?> arg0) {//根据类型判断
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int vote(Authentication aut, Object object, Collection<ConfigAttribute> attributes) {//投票操作
		//现在是根据IP地址来判断，并且项目不是通过WEB认证进行的
		if (!(aut.getDetails() instanceof WebAuthenticationDetails)) { 
			return AccessDecisionVoter.ACCESS_DENIED; //没有经过WEB认证，则拒绝你操作
		}
		//如果现在是来自于WEB认证授权操作
		WebAuthenticationDetails details = (WebAuthenticationDetails) aut.getDetails();
		String ip = details.getRemoteAddress(); //取得IP地址
		Iterator<ConfigAttribute> iterator = attributes.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = (ConfigAttribute) iterator.next();
			if ("IP_LOCAL_HOST ".equals(configAttribute.getAttribute())) {
				if ("0:0:0:0:0:0:0:1".equals(ip)) { //是本机的IP
					return AccessDecisionVoter.ACCESS_GRANTED;
				}
			}
		}
		return AccessDecisionVoter.ACCESS_ABSTAIN;
	}

}
