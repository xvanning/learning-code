package cn.mldn.dao;
import cn.mldn.vo.News;
public interface INewsDAO {
	public boolean doCreate(News vo) throws Exception;
}
