package com.spring.biz.user.impl;

import com.spring.biz.user.UserVO;

public class UserTest {
	
	public static void main(String[] args) {
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		vo.setName("관리자");
		vo.setRole("Admin");
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getuser(vo);
		System.out.println("user : "+ user);
		
	}
}
