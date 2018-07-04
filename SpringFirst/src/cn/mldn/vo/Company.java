package cn.mldn.vo;
import java.util.Arrays;
import java.util.Properties;
public class Company {
	private Properties msg[];
	
	@Override
	public String toString() {
		return "Company [msg=" + Arrays.toString(msg) + "]";
	}

	public Properties[] getMsg() {
		return msg;
	}

	public void setMsg(Properties[] msg) {
		this.msg = msg;
	}
}
