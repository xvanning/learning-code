package cn.mldn.action;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import cn.mldn.vo.Message;

@Controller
@RequestMapping("/pages/back/message/*")
public class MessageAction {
	@RequestMapping("message_insertpre")
	@Secured(value={"ROLE_ADMIN","IP_LOCAL_HOST"})
	public ModelAndView insertPre() {
		ModelAndView mav = new ModelAndView("/back/message/message_insert");
		return mav;
	}
	@RequestMapping("message_insert")
	@Secured(value={"ROLE_ADMIN","IP_LOCAL_HOST"})
	public ModelAndView insert(Message msg) {
		System.out.println("[增加数据]" + msg);
		ModelAndView mav = new ModelAndView("/forward");
		mav.addObject("msg","消息添加成功");
		mav.addObject("url","/pages/back/message/message_insertpre.action");
		return mav;
	}
	@RequestMapping("message_list")
	@Secured(value={"ROLE_ADMIN","ROLE_USER"})
	public ModelAndView list() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("[当前用户] " + userDetails.getUsername());
		System.out.println("[登陆密码] " + userDetails.getPassword());
		System.out.println("[用户角色] " + userDetails.getAuthorities());
		ModelAndView mav = new ModelAndView("/back/message/message_list");
		List<Message> all = new ArrayList<Message>();
		for (int i = 0; i < 10; i++) {
			Message msg = new Message();
			msg.setMid(i);
			msg.setTitle("MLDN - " + i);
			msg.setContent("www.mldn.cn");
			all.add(msg);
		}
		mav.addObject("allMessages",all);
		mav.addObject("url","/pages/back/message/message_list.action");
		return mav;
	}
	
	@RequestMapping("message_delete")
	@Secured(value={"ROLE_ADMIN"})
	public ModelAndView delete(Integer mid) {
		ModelAndView mav = new ModelAndView("/forward");
		System.out.println("[删除数据]" + mid);
		mav.addObject("msg","消息删除成功");
		mav.addObject("url","/pages/back/message/message_list.action");
		return mav;
	}
}
