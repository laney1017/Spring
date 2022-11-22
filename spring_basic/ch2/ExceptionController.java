package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {   
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 200번 상태코드를 500번 상태코드로 변경
	public String catcher(Exception ex, Model m) {  // model은 error.jsp로 전달하기 위해 사용 아래 main에서의 model과 다르다
		System.out.println("catcher() in ExceptionController");
		System.out.println("m="+m);
//		m.addAttribute("ex", ex);
		return "error";
	}
	@RequestMapping("/ex")
	public String main(Model m) throws Exception {  // 위의 catcher에서의 model과 다르다
		m.addAttribute("msg","message from ExceptionController.main()");
		throw new Exception("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception {
		throw new FileNotFoundException("예외가 발생했습니다.");
	}
}
