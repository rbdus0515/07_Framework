package edu.kh.project.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 예외처리용 컨트롤러(프로젝트 전역)
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public String excepStringtionHandler(Exception e, Model model) {

		// Exception e : 예외 정보를 담고있는 객체
		// Model model : 데이터 전달용 객체 (request scope 기본)

		e.printStackTrace(); // 예외 내용/발생 메서드 확인

		model.addAttribute("e", e); // 예외 발생 시 forward되는 페이지로 e를 전달함. (request scope도 가능)

		// 누구에 의해서?
		// 뷰리졸버(프리픽스, 서픽스를 붙여 jsp 경로를 만든다.)
		return "common/error";
	}

}
