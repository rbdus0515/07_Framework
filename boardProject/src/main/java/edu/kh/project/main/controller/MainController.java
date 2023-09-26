package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller : 현재 클래스가 컨트롤러임을 명시 -> 요청, 응답처리
// 				+ Bean 등록

// IOC 제어의 역전
// -> 프레임워크가 객체를 생성하고 관리
// --> 이때 생성된 객체를 == Bean이라 한다.


@Controller
public class MainController {

	// tip : spring에서 controller 메서드 작성 시
	// 반환값을 모르겠다면 일단 String으로 작성!
	
	// @RequestMapping("/") : 요청 주소가 "/"인 경우
	//						해당 메서드와 연결
	
	@RequestMapping("/")
	public String mainForward() {

		
		// Spring에서 forward 하는 방법!
		// -> webapp 폴더 기준으로
		// 요청 위임할 JSP 파일 경로를 리턴하면 된다!
		
		// 단, servlet-context.xml에 작성된
		// prefix, suffix 부분을 제외하고 작성!
		// -> prefix + 리턴값 + suffix 로 경로 완성
		// **  View Resolver **
		return "common/main";
	}
}
