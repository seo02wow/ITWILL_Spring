package com.spring.biz.view.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@Controller
public class UserController {
	
	//@RequestMapping(value = "/login.do",method = RequestMethod.POST) 
	@PostMapping("/login.do")
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
	
	// value = "요청명"
	//method = RequestMethod.GET (GET 방식 요청일 때 사용할 메소드라고 명시)
	//@RequestMapping - GET , POST 둘다 처리
	//@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	/* @ModelAttribute : 모델(Model)의 속성값으로 저장(속성명 별도 저장)
	  
	 */
	@GetMapping("/login.do")
	public String loginView(@ModelAttribute("user") UserVO vo) { // 단순 화면 이동 ,DB 연동 작업 X
		//@ModelAttribute("user") :  UserVO를 "user"라는 이름으로 사용 가능 
		System.out.println(">>> 로그인 화면 이동 - loginView()");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	@RequestMapping("/logout.do") // 
	public String logout(HttpSession session){
		System.out.println(">>> 로그아웃 처리");
		//1. 세션 초기화(세션 객체 무효화)
		session.invalidate();
		
		return "login.jsp";
	}
	
}
