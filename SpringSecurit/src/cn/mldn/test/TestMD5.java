package cn.mldn.test;

import cn.mldn.util.MD5;

public class TestMD5 {

	public static void main(String[] args) {
		MD5 md5 = new MD5();
		System.out.println(md5.getMD5("java"));
	}

}
