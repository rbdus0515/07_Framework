package edu.kh.project.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.board.model.service.CommentService;
import edu.kh.project.member.model.dto.Member;

// @Controller + @ResponseBody

@RestController // 요청,응답 처리 (단, 모든 요청 응답은 비동기)
				// -> REST API를 구축하기 위한 Controller
public class CommentController {

	@Autowired
	private CommentService service; 
	
	// 댓글 목록 조회					// json 통신 시 한글 깨짐 방지
	@GetMapping(value = "/comment", produces = "application/json; charset=UTF-8")
	public List<Comment> selectCommnet(int boardNo) {
		
		return service.selectComment(boardNo);
		// 동기 시 return : forward / redirect
		// 비동기 시 return : 값 자체
	}
	
	// 댓글 삽입
	@GetMapping(value = "/{boardCode}/{boardNo}/comment/insert")
	public String insertComment(
					@PathVariable("boardNo") int boardNo,
					@PathVariable("boardCode") int boardCode,
					Comment comment,
					@SessionAttribute("loginMember") Member loginMember
					) {
		
		comment.setMemberNo(loginMember.getMemberNo());
		
		comment.setBoardNo(boardNo);
		
		int commentNo = service.insertComment(comment);
		
		String path = "redirect:";
		
		if(commentNo > 0) {
			path += "/board/" + boardCode + "/" + boardNo;
		} else {
			path += "insert";
		}
		
		return path;
	}
	
	// 댓글 삭제
	public String delete() {
		return null;
	}
	
	// 댓글 수정
	public String update() {
		return null;
	}
	
}




























