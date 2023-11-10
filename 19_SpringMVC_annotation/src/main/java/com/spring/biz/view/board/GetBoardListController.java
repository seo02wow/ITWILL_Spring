package com.spring.biz.view.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController{
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardDAO boardDAO, ModelAndView mav)
			throws ServletException, IOException {
		System.out.println(">>> 게시글 전체 목록 보여주기");
		//1. 게시글 목록 조회(SELECT) 
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		// 데이터 전달 + 뷰도 전달해야 되기 때문에 ModelAndView 사용해야 함 
		mav.addObject("boardList", boardList); // 데이터 저장 (Model에 데이터 저장)
		mav.setViewName("getBoardList.jsp"); // 뷰 명칭 (View 명칭 저장)
		
		// 모델 객체와 뷰 둘다 전달 
		return mav;
	}
	
}
