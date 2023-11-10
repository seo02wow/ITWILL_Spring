package com.spring.biz.view.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class UpdateBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">>> 게시글 수정");
		//1. 전달받은 데이터 확인(추출) 
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		//2. DB 연동작업(수정)
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		ModelAndView mav = new ModelAndView();
		//3. 페이지 전환
		// 수정된 데이터와 함께 목록페이지로 이동
		//response.sendRedirect("getBoardList.do");
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}

	

}
