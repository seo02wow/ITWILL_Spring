package com.spring.biz.view.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController{

	@RequestMapping("/logout.do")
	public String logout(HttpSession session)
			throws ServletException, IOException {
		System.out.println(">>> 로그아웃 처리");
		//1. 세션 초기화(세션 객체 무효화)
		session.invalidate();
		
		
		return "login.jsp";
	}

}
