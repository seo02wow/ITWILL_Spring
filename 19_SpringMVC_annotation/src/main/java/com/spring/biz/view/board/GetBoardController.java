package com.spring.biz.view.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">>> 게시글 상세 보여주기");
		
		//1. 전달받은 데이터 확인(추출) 
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//2-1. DB 연동작업(게시글 1개 조회)  
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		
		BoardVO board = boardDAO.getBoard(vo);
		
		//2-2. 검색 결과를 세션에 저장(뷰에서 사용 가능하도록)
		//HttpSession session = request.getSession();
		//session.setAttribute("board", board);
		
		//3. 화면 전환 (상세페이지로 이동)
		//response.sendRedirect("getBoard.jsp");
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		
		
		return mav;
	}

}
