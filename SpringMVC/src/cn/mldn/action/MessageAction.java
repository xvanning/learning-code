package cn.mldn.action;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.service.IMessageService;
import cn.mldn.vo.*;
@Controller
@RequestMapping("/pages/back/message/*")  //整体的访问路径
public class MessageAction {
	@Resource
	private IMessageService messageService;
	@Resource
	private MessageSource messageSource;
	
	@RequestMapping("message_insert") 
	public ModelAndView insert(Message msg) throws Exception {
		ModelAndView mav = new ModelAndView("/forward");
		System.out.println(this.messageService.insert(msg));
		mav.addObject("msg", "消息添加成功");
		mav.addObject("url", "/pages/back/message/message_insert.jsp");
		return mav;
	}
	@RequestMapping("message_update")
	public ModelAndView update(Message msg,Type type) throws Exception{
		msg.setType(type);
		ModelAndView mav = new ModelAndView("/forward");
		System.out.println(this.messageService.update(msg));
		mav.addObject("msg", "消息修改成功");
		mav.addObject("url", "/pages/back/message/message_update.jsp");
		return mav;
	}
	@RequestMapping("message_delete")
	public ModelAndView delete(
			@RequestParam(value="paramids",defaultValue="0") String ids) throws Exception {
		ModelAndView mav = new ModelAndView("/forward");
		Set<Integer> set = new HashSet<Integer>();
		String result[] = ids.split("\\-");
		for (int x = 0; x < result.length; x++) {
			set.add(Integer.parseInt(result[x]));
		}
		System.out.println(this.messageService.delete(set));
		mav.addObject("msg", "消息删除成功");
		mav.addObject("url", "/index.jsp");
		return mav;
	}
	@RequestMapping("message_get")
	public ModelAndView get(int mid) throws Exception{
		ModelAndView mav = new ModelAndView("/forward");
		System.out.println("返回对象： " + this.messageService.get(mid));
		mav.addObject("msg", "消息查询成功");
		mav.addObject("url", "/index.jsp");
		return mav;
	}
	@RequestMapping("message_list")
	public ModelAndView list(String col, String kw, int cp, int ls) throws Exception{
		ModelAndView mav = new ModelAndView("/forward");
		System.out.println("###[分页参数] col = " + col);
		System.out.println("###[分页参数] kw = " + kw);
		System.out.println("###[分页参数] cp = " + cp);
		System.out.println("###[分页参数] ls = " + ls );
		System.out.println("返回对象： " + this.messageService.list(col, kw, cp, ls));
		mav.addObject("msg", "消息分页成功");
		mav.addObject("url", "/index.jsp");
		return mav;
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) { //进行WEB数据的转换绑定
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//注册一个专门的日期转换器的操作类，并且允许输入的数据为空
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	@RequestMapping("inner")
	public ModelAndView inner(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		System.out.println("绝对路径： " + application.getRealPath("/"));
		System.out.println("SESSION ID: " + session.getId());
		response.getWriter().print("<h1>www.mldn.cn</h1>");
		return null; //返回Null表示不跳转
	}
	@RequestMapping("message_insertPre")
	public ModelAndView insertPre() {
		System.out.println("属性内容： " + this.messageSource.getMessage("info.msg", new Object[] {"www.mldn.cn"} , Locale.getDefault()));
		System.out.println("属性内容： " + this.messageSource.getMessage("message.insert.action", null , null));
		ModelAndView mav = new ModelAndView("/back/message/message_insert");
		return mav;
	}
}
