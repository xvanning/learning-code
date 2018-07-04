package cn.mldn.demo;
import java.sql.Connection;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBCDemoA {
	public static void main(String[] args) throws Exception {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://127.0.0.1:3306/springdb?useUnicode=true&characterEncoding=utf8&useSSL=false&failOverReadOnly=false&serverTimezone=UTC ");
		source.setUsername("root");
		source.setPassword("635241");
		Connection connection = source.getConnection();
		System.out.println(connection);
	}
}
