package com.spring.biz.view.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;


public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">>> 로그인 처리");
		//1. 사용자 전달한 데이터(정보) 확인(추출)
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		//2. DB 연동 작업(id,password 유무확인)
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getuser(vo);
		
		//3. 화면 네비게이션(화면전환, 화면이동)
		//로그인 성공 : 게시글 목록 보여주기 
		//로그인 실패 : 로그인 화면으로 이동 
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			System.out.println(">> 로그인 성공 !!");
			//response.sendRedirect("getBoardList.do");
			//returnStr = "getBoardList.do";
			// .do -> viewResolver 처리 안 됨 ! (왜 )
			mav.setViewName("redirect:getBoardList.do");
		} else {
			System.out.println(">> 로그인 실패 !!");
			//mav.setViewName("login.jsp");
			mav.setViewName("redirect:login.jsp");
			//viewResolver 적용 안 함 (재요청처리)
		}
		// 기본 포워드 처리- viewResolver
		return mav;
	}

}
