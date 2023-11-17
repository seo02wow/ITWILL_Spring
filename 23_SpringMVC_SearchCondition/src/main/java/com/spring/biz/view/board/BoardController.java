package com.spring.biz.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo,BoardDAO boardDAO,Model model) {
		System.out.println(">>> 게시글 상세 보여주기");
		System.out.println("vo : " + vo);
		
		//2-1. DB 연동작업(게시글 1개 조회)  
		BoardVO board = boardDAO.getBoard(vo);
		
		//mav.addObject("board", board); // 데이터 저장
		model.addAttribute("board", board);
		
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo,BoardDAO boardDAO, Model model){
		System.out.println(">>> 게시글 전체 목록 보여주기");
		System.out.println("vo : " + vo);
		
		//1. 게시글 목록 조회(SELECT) 
		//List<BoardVO> boardList = boardDAO.getBoardList();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		model.addAttribute("boardList", boardList);
		
		// 모델 객체와 뷰 둘다 전달 
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO){
		System.out.println(">>> 게시글 입력");
		System.out.println(" vo : " + vo);
		
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String handleRequest(BoardVO vo, BoardDAO boardDAO){
		System.out.println(">>> 게시글 삭제");
		//1. 전달받은 데이터 확인(추출) 
	
		//2. DB 연동작업(삭제)
		boardDAO.deleteBoard(vo);
		
		//3. 페이지 전환
		
		// 화면전환만 필요할 경우 String 리턴 
		// 모델앤뷰는 무거움
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo,BoardDAO boardDAO){
		System.out.println(">>> 게시글 수정");
		System.out.println("vo : " + vo);
		
		boardDAO.updateBoard(vo);
		//3. 페이지 전환
		
		return "getBoardList.do";
	}
	
}
