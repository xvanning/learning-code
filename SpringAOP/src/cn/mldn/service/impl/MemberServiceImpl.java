package cn.mldn.service.impl;
import org.springframework.stereotype.Service;

import cn.mldn.service.IMemberService;
import cn.mldn.vo.Member;
@Service
public class MemberServiceImpl implements IMemberService{
	@Override
	public boolean insert(Member vo) {
		//throw new NullPointerException("我就是爱抛");
		System.out.println("[数据层调用]member = " + vo); 
		return true;
	}
}
