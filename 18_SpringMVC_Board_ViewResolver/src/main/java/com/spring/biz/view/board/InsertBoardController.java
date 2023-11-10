package com.spring.biz.view.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class InsertBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">>> 게시글 입력");
		//1. 전달받은 데이터 추출
		 String title = request.getParameter("title");
		 String content = request.getParameter("content");
		 String writer = request.getParameter("writer");
		//2. DB 연동작업(입력)
		 BoardVO vo = new BoardVO();
		 vo.setTitle(title);
		 vo.setContent(content);
		 vo.setWriter(writer);
		 
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		 
		//3. 페이지 전환 - 목록페이지로 이동 
		//(jsp X,새로운 데이터: 방금 입력한 데이터 를 가지고 이동할 수 있도록) 
		//response.sendRedirect("getBoardList.do");
		//return "getBoardList"
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}

}
