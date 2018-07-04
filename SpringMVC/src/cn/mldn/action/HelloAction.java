package cn.mldn.action;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import cn.mldn.vo.News;

@Controller
@RequestMapping("/pages/hello/*")
public class HelloAction {
	private static String insertRule = "nid:int|title:string";
	private static String mimeRule = "image/jpeg,image/jpg,image/png";
	@RequestMapping("insert")
	public ModelAndView insert(News vo,MultipartFile pic) {
		System.out.println("****** hello world ******");
		System.out.println(vo);
		System.out.println("[文件大小] " + pic.getSize());
		return null;
	}
}
