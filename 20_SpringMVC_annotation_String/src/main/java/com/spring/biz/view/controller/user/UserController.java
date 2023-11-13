package com.spring.biz.view.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@Controller
public class UserController {
	
	@RequestMapping("/login.do") 
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println(">>> 로그인 처리");
		System.out.println("vo : " + vo);
		
		UserVO user = userDAO.getuser(vo);
		System.out.println("user : " + user);
		
		//3. 화면 네비게이션(화면전환, 화면이동)
		//로그인 성공 : 게시글 목록 보여주기 
		//로그인 실패 : 로그인 화면으로 이동 
		if(user != null) {
			System.out.println(">> 로그인 성공 !!");
			return "getBoardList.do";
		} else {
			System.out.println(">> 로그인 실패 !!");
			return "login.jsp";
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		System.out.println(">>> 로그아웃 처리");
		//1. 세션 초기화(세션 객체 무효화)
		session.invalidate();
		
		return "login.jsp";
	}
	
}
