package cn.mldn.userdetails.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
@Component
public class UserDetailsImpl implements UserDetailsService {
	@Resource
	private JdbcTemplate jt;
	@Override
	public UserDetails loadUserByUsername(final String mid) throws UsernameNotFoundException {
		String sql = "SELECT mid,password,enabled FROM member WHERE mid=?";
		UserDetails det = this.jt.queryForObject(sql,
				new RowMapper<UserDetails>(){
			@Override 
			public UserDetails mapRow(ResultSet rs, int row) throws SQLException {
				//当查询完数据后，表示用户名存在，但是还没角色
				String sql2 = "SELECT title FROM role WHERE mid=?";
				//查询出一个用户所具备的所有角色名称
				List<String> titles = UserDetailsImpl.this.jt.queryForList(sql2,String.class,mid);
				//在spring安全框架之中必须将角色信息传递给指定的类型
				List<GrantedAuthority> allGA = new ArrayList<GrantedAuthority>();
				Iterator<String> iterator = titles.iterator();
				while (iterator.hasNext()) {
					allGA.add(new SimpleGrantedAuthority(iterator.next()));  //实例化GrantedAuthority
				}
				//最终的结果所有的用户数据和权限信息需要保存在UserDeatails接口对象里面
				return new User(rs.getString(1),rs.getString(2), rs.getInt(3)==1, true, true, true, allGA);
			} 
			
		},mid);
		if (det == null) {
			throw new UsernameNotFoundException(mid + "该用户信息不存在");
		}
		return det;
	}

}
