package cn.mldn.demo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class JDBCDemoB {
	public static void main(String[] args) throws Exception {
		//1、数据库的连接必须首先处理
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://127.0.0.1:3306/springdb?useUnicode=true&characterEncoding=utf8&useSSL=false&failOverReadOnly=false&serverTimezone=UTC ");
		source.setUsername("root");
		source.setPassword("635241");
		//2、处理JDBC的相关操作
		KeyHolder key = new GeneratedKeyHolder();//取得自动增长列
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(source);
		final String sql = "INSERT INTO news(title,pubdate,content) VALUES (?,?,?)";
		int count = jt.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, "好好学习");
				pstmt.setDate(2,new java.sql.Date(new Date().getTime()));
				pstmt.setString(3, "天天向上");
				return pstmt;
			}
		},key);
		System.out.println("更新数据行数： " + count + ", 当前ID： " + key.getKey());
		source.getConnection().close();
	}
}
