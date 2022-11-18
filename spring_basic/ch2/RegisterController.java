package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // ctrl+shift+o �ڵ� import
public class RegisterController {
//	@RequestMapping("/register/add") // �ű�ȸ�� ���� ȭ��
//	@GetMapping("/register/add") // GET������θ� ���ٰ���
//	public String register( ) {
//		return "registerForm"; // WEB-INF/views/registerForm.jsp
//	} // registerForm ȭ�鸸 �����ְ� ������ �ϴ����� ���� ������ viewcontroller�� �ٲ㺸���Ѵ�. 
	  // spring ������ ���������� servlet-context.xml ���Ͽ��� ���� <view-controller path="/register/add" view-name="registerForm"/>
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // GET������� ���ٺҰ�
	@PostMapping("/register/save") // PostMapping POST������θ� ���ٰ��� spring 4.3���� ��밡��
	public String saver( ) {
		return "registerInfo";
	}
}
