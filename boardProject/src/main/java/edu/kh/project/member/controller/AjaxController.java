package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.project.member.model.service.AjaxService;

@Controller // 요청/응답 제어 + baen 등록
public class AjaxController {
	
	@Autowired
	private AjaxService service;

	// ** 닉네임으로 전화번호 조회
	@GetMapping("/selectMemberTel")
	@ResponseBody
	public String selectMemberTel(String nickname) {
							// 쿼리스트링에 담겨있는 파라미터
		
		// return 리다이렉트 / 포워드 -> 새로운 화면 보임 (기동식)
		
		// return 데이터 -> 테이더를 요청한 곳으로 반환(비동기식)
		
		// @RespomseBody
		// -> Controller의 결과로 데이터를 반환할 떄 사용하는 어노테이션 
		
		return service.selectMemberTel(nickname);
	}
	
}
