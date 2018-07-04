package cn.mldn.demo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import cn.mldn.vo.News;
public class JDBCDemoD {
	public static void main(String[] args) throws Exception {
		//1、数据库的连接必须首先处理
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://127.0.0.1:3306/springdb?useUnicode=true&characterEncoding=utf8&useSSL=false&failOverReadOnly=false&serverTimezone=UTC ");
		source.setUsername("root");
		source.setPassword("635241");
		//2、处理JDBC的相关操作
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(source);
		String sql = "SELECT nid,title,pubdate,content FROM news WHERE title LIKE ? LIMIT ?,?";
		List<News> all = jt.query(sql,new RowMapper<News>(){
			@Override
			public News mapRow(ResultSet rs, int rowCount) throws SQLException {
				System.out.println("返回的数据行数： " + rowCount);
				News vo = new News();
				vo.setNid(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPubdate(rs.getDate(3));
				vo.setContent(rs.getString(4));	
				return vo;
			}	
		},"%%",0,2);	
		System.out.println(all);
		source.getConnection().close();
	}
}
