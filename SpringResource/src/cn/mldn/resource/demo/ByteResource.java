package cn.mldn.resource.demo;
import java.io.IOException;
import java.util.Scanner;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

public class ByteResource {
	public static void main(String[] args) throws Exception {
		
		//此处内存处理流与之前讲解的ByteArrayInputStream使用形式类似
		Resource source = new ByteArrayResource("helloworld".getBytes());
		//单单就可以取得更多的资源信息来讲，这一点就比InputStream要强
		System.out.println("数据长度： " + source.contentLength());
		//如果给出的是InputStream，那么可以利用Scanner简化读取
		//getInputStream是通过InputStreamSource父接口继承而来的方法
		Scanner scan =new Scanner(source.getInputStream());
		if (scan.hasNext()) {
			System.out.println(scan.next());
		}
	}
}
