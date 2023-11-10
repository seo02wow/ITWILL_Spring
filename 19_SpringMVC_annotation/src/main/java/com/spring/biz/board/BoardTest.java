package com.spring.biz.board;

import java.util.List;

import com.spring.biz.board.impl.BoardDAO;

public class BoardTest {

	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트2 - 수정");
		vo.setWriter("홍길동2 - 수정");
		vo.setContent("테스트2-내용 수정");
		
		BoardDAO dao = new BoardDAO();
		
		// insert
		//dao.insertBoard(vo);
		
		// delete 
		//dao.deleteBoard(vo); // 삭제 성공 
		
		// update
		//dao.updateBoard(vo); // 업데이트 성공 
	
		
		// select - 목록
		System.out.println(">> 전체목록 조회");
		List<BoardVO> boardList = dao.getBoardList();
		for (BoardVO board : boardList) {
			System.out.println("목록 조회 : " + board);
		}
		
		// select - 1개
		vo.setSeq(1);
		BoardVO board = dao.getBoard(vo);
		System.out.println("board : " + board);

	}

}
