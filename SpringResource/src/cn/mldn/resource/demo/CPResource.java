package cn.mldn.resource.demo;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class CPResource {
	public static void main(String[] args) throws Exception {
		
		ResourcePatternResolver loader = new PathMatchingResourcePatternResolver();
		Resource[] resources = loader.getResources("classpath:cn/msg/**/applicationContext-?.xml");
		for (int i = 0; i < resources.length; i++) {
			System.out.println("文件名称: " + resources[i].getFilename() + ", 数据长度： " + resources[i].contentLength());
		}
	}
}
