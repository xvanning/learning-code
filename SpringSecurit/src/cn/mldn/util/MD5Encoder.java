package cn.mldn.util;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component(value="md5")
public class MD5Encoder implements PasswordEncoder {

	@Override
	public String encodePassword(String pwd, Object salt) {
		return new MD5().getMD5(pwd);
	}

	@Override
	public boolean isPasswordValid(String pwd, String orig, Object salt) {
		return pwd.equals(new MD5().getMD5(orig));
	}

}
