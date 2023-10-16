package edu.kh.project.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"loginMember"})
@RequestMapping("/board")
@Controller
public class BoardController {

	/* 목록 조회 : /board/1?cp=1 (cp: current page(현재페이지))
	 * 상세 조회 : /board/1/1500?cp=1
	 * 
	 * ** 컨트롤러 따로 생성 **
	 * 삽입 : /board2/1/insert
	 * 수정 : /board2/1/1500/update
	 * 삭제 : /board2/1/1500/delete
	 */
	
	/*
	 * *** @PathVariable 사용시 문제점과 해결법 ***
	 * 
	 * 문제점 : 요청 주소화 @PathVariable로 가져다 쓸 주소의 레벨아 같다면
	 * 			구분하지 않고 모두 맵핑되는 문제가 발생
	 * 
	 * 해결방법 : @PathVariable지정 시 정규 표현식 사용
	 * {키:정규표현식}
	 * 
	 */

	@GetMapping("/{boardCode:[0-9]+}")
	public String selectBoardList( @PathVariable("boardCode") int boardCode) {
		
		// boardCode 확인
		System.out.println("boardCode : "+ boardCode);
		
		return "board/boardList";
	}
	
	
	
	
}
