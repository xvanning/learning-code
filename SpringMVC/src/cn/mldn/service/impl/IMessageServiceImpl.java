package cn.mldn.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;
import cn.mldn.service.IMessageService;
import cn.mldn.vo.Message;
import cn.mldn.vo.Type;

@Service
public class IMessageServiceImpl implements IMessageService {

	@Override
	public boolean insert(Message vo) throws Exception {
		System.out.println("****[增加新消息]" + vo);
		return true;
	}

	@Override
	public boolean update(Message vo) throws Exception {
		System.out.println("****[更新消息数据]" + vo);
		return true;
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		System.out.println("****[删除消息]" + ids);
		return true;
	}

	@Override
	public Message get(int id) throws Exception {
		System.out.println("****[根据id查询数据]****");
		Message msg = new Message();
		msg.setMid(100009);
		msg.setTitle("MLDN");
		msg.setPrice(99999.99);
		msg.setPubdate(new Date());
		Type type = new Type();
		type.setTypeTitle("教育新闻");
		msg.setType(type);
		return msg;
	}

	@Override
	public Map<String, Object> list(String column, String keyword, int currentPage, int lineSize) throws Exception {
		System.out.println("****[执行分页操作]****");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Message> all = new ArrayList<Message>();
		for (int x = (currentPage - 1) * lineSize; x < currentPage * lineSize; x++) {
			Message msg = new Message();
			msg.setMid(100 + x);
			msg.setTitle("MLDN - " + x);
			msg.setPrice(10000.0 + x);
			msg.setPubdate(new Date());
			Type type = new Type();
			type.setTypeTitle("教育新闻 - " + x);
			msg.setType(type);
			all.add(msg);
		}
		map.put("allMessage", all);
		map.put("messageCount", 888);
		return map;
	}

}
