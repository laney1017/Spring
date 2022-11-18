package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // ctrl+shift+o 자동 import
public class RegisterController {
//	@RequestMapping("/register/add") // 신규회원 가입 화면
//	@GetMapping("/register/add") // GET방식으로만 접근가능
//	public String register( ) {
//		return "registerForm"; // WEB-INF/views/registerForm.jsp
//	} // registerForm 화면만 보여주고 실제로 하는일이 없기 때문에 viewcontroller로 바꿔보려한다. 
	  // spring 웹관련 설정파일인 servlet-context.xml 파일에서 적용 <view-controller path="/register/add" view-name="registerForm"/>
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // GET방식으로 접근불가
	@PostMapping("/register/save") // PostMapping POST방식으로만 접근가능 spring 4.3부터 사용가능
	public String saver( ) {
		return "registerInfo";
	}
}
