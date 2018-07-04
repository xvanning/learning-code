package cn.mldn.dao.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import cn.mldn.dao.INewsDAO;
import cn.mldn.vo.News;
@Component
public class INewsDAOImpl extends JdbcDaoSupport implements INewsDAO {
	private JdbcTemplate jt;
	@Autowired //自动根据匹配类型注入所需要的数据
	public INewsDAOImpl(JdbcTemplate jt) {
		super.setJdbcTemplate(jt);
	}
	
	@Override
	public boolean doCreate(News vo) throws Exception {
		
		String sql = "INSERT INTO news(title,pubdate,content) VALUES (?,?,?)";
		int count = super.getJdbcTemplate().update(sql,vo.getTitle(),vo.getPubdate(),vo.getContent());
		return count > 0;
	}
	
}
