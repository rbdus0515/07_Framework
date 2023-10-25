package edu.kh.project.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	// 댓글 등록
	@PostMapping("/comment")
	public int insertComment(@RequestBody Comment comment) {
						// 요청 데이터(JSON)
						// HttpMessageConverter가 해석 -> Java 객체(comment)에 대입
		
		return service.insertComment(comment);
	}
	
	// 댓글 삭제
	@GetMapping("/comment/delete")
	public int deleteComment(int commentNo) {
		return service.deleteComment(commentNo);
	}
	
	// 댓글 수정
	@PostMapping("/comment/update")
	public int updateComment(@RequestParam Comment comment) {
		return service.updateComment(comment);
	}
	
}




























