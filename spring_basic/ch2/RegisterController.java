package com.fastcampus.ch2;

import java.net.URLEncoder;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o �ڵ� import
@RequestMapping("/register")
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
//		System.out.println("conversionService=" + conversionService);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, "hobby",new StringArrayPropertyEditor("#"));
//		binder.setValidator(new UserValidator()); // UserValidator�� WebDataBinder�� ���� validator�� ���
//		binder.addValidators(new UserValidator()); // UserValidator�� WebDataBinder�� ���� validator�� ���
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList="+ validatorList);
	}
	@RequestMapping(value="/add", method= {RequestMethod.GET}) // �ű�ȸ�� ���� ȭ��
	public String register( ) {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	} // registerForm ȭ�鸸 �����ְ� ������ �ϴ����� ���� ������ viewcontroller�� �ٲ㺸���Ѵ�. 
	  // spring ������ ���������� servlet-context.xml ���Ͽ��� ���� <view-controller path="/register/add" view-name="registerForm"/>
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // GET������� ���ٺҰ�
	@PostMapping("/add") // PostMapping POST������θ� ���ٰ��� spring 4.3���� ��밡��
	public String save(@Valid User user, BindingResult result, Model m) throws Exception{ 
		System.out.println("result="+result);
		System.out.println("user="+user);
		
		// ���� ���� - Validator�� ���� �����ϰ�, validate()�� ���� ȣ��
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result); // BindingResult�� Error�� �ڼ�
		
		// User��ü�� ������ ��� ������ ������, registerForm�� �̿��ؼ� ������ ������� ��. 
		if(result.hasErrors()) {
			return "registerForm";
		}
//		// 1. ��ȿ�� �˻�
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			return "forward:/register/add";
////			return "redirect:/register/add?msg="+msg; // URL���ۼ�(rewriting) �� ���ٰ� ����.
//		}
		// 2. DB�� �ű�ȸ�� ������ ����
		return "registerInfo";
	}

	private boolean isValid(User user) {
	return true;
	}
}
