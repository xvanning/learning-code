package cn.mldn.resource.demo;
import java.util.Scanner;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class FileResourceLoader {
	public static void main(String[] args) throws Exception {
		ResourceLoader loader = new DefaultResourceLoader();
		Resource source = loader.getResource("classpath:META-INF/license.txt");
		System.out.println("数据长度： " + source.contentLength());
		Scanner scan =new Scanner(source.getInputStream());
		scan.useDelimiter("\n");
		while (scan.hasNext()) {
			System.out.println(scan.next());
		}
	}
}
