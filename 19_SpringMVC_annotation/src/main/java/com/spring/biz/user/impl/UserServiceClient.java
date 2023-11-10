package com.spring.biz.user.impl;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

public class UserServiceClient {
	public static void main(String[] args) {
System.out.println("----- 스프링 컨테이너 구동 전 -----");
		
		//1. 스프링 컨테이너 구동(스프링 설정 파일 읽어서) 
		GenericXmlApplicationContext container 
				= new GenericXmlApplicationContext("applicationContext.xml"); 
		System.out.println("----- 스프링 컨테이너 구동 후 -----");
		
		//2. 스프링 컨테이너 사용 
		UserService userService = (UserService)container.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("user1");
		vo.setPassword("user1");
		
		System.out.println("user1 : " + userService.getuser(vo));
		
		System.out.println("----- 스프링 컨테이너 종료처리 -----");
		//3. 스프링 컨테이너 종료
		container.close();
		
	}
}
