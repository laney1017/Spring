package com.fastcampus.ch2;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o �ڵ� import
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST}) // �ű�ȸ�� ���� ȭ��
	public String register( ) {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	} // registerForm ȭ�鸸 �����ְ� ������ �ϴ����� ���� ������ viewcontroller�� �ٲ㺸���Ѵ�. 
	  // spring ������ ���������� servlet-context.xml ���Ͽ��� ���� <view-controller path="/register/add" view-name="registerForm"/>
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // GET������� ���ٺҰ�
	@PostMapping("/register/save") // PostMapping POST������θ� ���ٰ��� spring 4.3���� ��밡��
	public String save(User user, BindingResult result, Model m) throws Exception{ 
		System.out.println("result="+result);
		// 1. ��ȿ�� �˻�
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
			
			m.addAttribute("msg", msg);
			return "forward:/register/add";
//			return "redirect:/register/add?msg="+msg; // URL���ۼ�(rewriting) �� ���ٰ� ����.
		}
		// 2. DB�� �ű�ȸ�� ������ ����
		return "registerInfo";
	}

	private boolean isValid(User user) {
	return true;
	}
}
