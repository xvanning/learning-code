package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IMemberDAO;
import com.service.IMemberService;
import com.pojo.Member;

@Service
public class MemberServiceImpl implements IMemberService {
	@Resource
	private IMemberDAO memberDAO;

	@Override
	public boolean add(Member vo) throws Exception {
		return this.memberDAO.doCreate(vo);
	}

	@Override
	public List<Member> split(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", column); 
		map.put("keyWord", "%" + keyWord + "%");
		map.put("start", (currentPage - 1) * lineSize);
		map.put("lineSize", lineSize);
		return this.memberDAO.findAllSplit(map);
	}

}
