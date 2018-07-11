package com.controller;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.IMemberService;
import com.pojo.Member;

@Controller
@Scope(scopeName="prototype")
@RequestMapping("/member/*")
public class MemberAction {
	private Logger log = Logger.getLogger(MemberAction.class) ;
	@Resource
	private IMemberService memberService ;
	@RequestMapping("add")
	public ModelAndView add(Member vo) throws Exception {
		log.info(vo);
		log.info("数据增加处理结果：" + this.memberService.add(vo));
		return null ;
	} 
	@RequestMapping("split")
	public ModelAndView split(String col, String kw, int cp, int ls) throws Exception {
		log.info("col = " + col + "、kw = " + kw + "、cp = " + cp + "、ls = " + ls);
		log.info("数据查询结果：" + this.memberService.split(col, kw, cp, ls));
		return null ;
	} 
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
