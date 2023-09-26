package edu.kh.project.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.project.member.model.dto.Member;

@Controller // 요청,응답 클래스 + Bean 등록(Spring 관리하는 객체)
@RequestMapping("/member") // 공통된 주소 앞부분 작성, member로 시작하는 요청은 해당 컨트롤러에서 처리
public class MemberController {

	// 로그인 : /member/login
	// 로그아웃 : /member/logout
	
	// /member/login , post 처리방식
	
	// @RequestMapping : 요청 주소에 맞는 클래스/메서드 연결
	// @RequestMapping("요청주소") -> GET / POST 구분 X , 주소만 맞으면 연결하지만 GET요청시 사용
	//	@RequestMapping(value="/login" , method=RequestMethod.GET/POST) -> 방식을 구분

	// @RequestMapping(value="/login" , method=RequestMethod.POST)
	public String login(HttpServletRequest req) {
		
		// 파라미터 전달 방법 1 : HttpServletRequset를 이용하는 방법
		// -> Controller 메서드에 매개변수로 HttpServletRequest를 작성
		
		// 매개변수에 적으면 사용 가능한 이유
		// Spring 제공하는 Argument Resolver(매개변수해결사)가 자동으로
		// 대입해주고 해결해줌.
		
		String inputEmail = req.getParameter("inputEmail");
		String inputPw = req.getParameter("inputPw");
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		// --- redirect 방법! ---
		// "redirect : 요청주소"
		
		return "redirect:/";
	}
	
	
	// @PostMapping : @RequestMapping 자식으로
	// 				Post 방식 요청을 연결하는 어노테이션
	// @PostMapping("/login")
	public String login(/*@RequestParam("inputEmail")*/ String inputEmail,
						/*@RequestParam("inputPw")*/ String inputPw) {

		// 파라미터 전달방법 2 : @RequestParam 어노테이션 이용(+생략방법)
		
		// @RequestParam 어노테이션
		// - request 객체를 이용한 파라미터 전달 어노테이션
		// - 매개변수 앞에 해당 어노테이션 작성하면 , 매개변수에 값이 주입됨.
		
		// ** 파라미터의 name속성값과
		// 	매개변수명이 같으면 @RequestParam 생략가능!
		

		// @RequestParam(value="name", required="fasle", defaultValue="1")
		// [속성]
		// value : 전달 받은 input 태그의 name 속성값

		// required : 입력된 name 속성값 파라미터 필수 여부 지정(기본값 true)
		// -> required = true인 파라미터가 존재하지 않는다면 400 Bad Request 에러 발생
		// -> required = true인 파라미터가 null인 경우에도 400 Bad Request

		// defaultValue : 파라미터 중 일치하는 name 속성 값이 없을 경우에 대입할 값 지정.
		// -> required = false인 경우 사용
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);

		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String login(/*@ModelAttribute*/ Member inputMember) {
		
		// 파라미터 전달 방법 3 : @ModelAttribute 이용한 방법
		
		// - DTO(또는 VO)와 같이 사용하는 어노테이션
		
		// - 전달 받은 파라미터의 name속성 값이
		// 	같이 사용되는 DTO의 필드명과 같다면
		// 	자동으로 setter를 호출해서 필드에 값을 세팅
		
		System.out.println(inputMember);
		
		// ** @ModelAttribute 사용 시 주의 사항 **
		// - DTO에 기본 생성자가 필수로 존재
		// - DTO에 setter가 필수로 존재해야 한다.
		
		// ** @ModelAttribute 어노테이션은 생략이 가능하다! **
	
		// ** @ModelAttribute를 이용해 값이 필드에 세팅된 객체를 커맨드 객체라고 부른다.
		
		
		return "redirect:/";
	}
	
	
	
}
























