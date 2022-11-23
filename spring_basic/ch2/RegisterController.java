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

@Controller // ctrl+shift+o 자동 import
@RequestMapping("/register")
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
//		System.out.println("conversionService=" + conversionService);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, "hobby",new StringArrayPropertyEditor("#"));
//		binder.setValidator(new UserValidator()); // UserValidator를 WebDataBinder의 로컬 validator로 등록
//		binder.addValidators(new UserValidator()); // UserValidator를 WebDataBinder의 로컬 validator로 등록
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList="+ validatorList);
	}
	@RequestMapping(value="/add", method= {RequestMethod.GET}) // 신규회원 가입 화면
	public String register( ) {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	} // registerForm 화면만 보여주고 실제로 하는일이 없기 때문에 viewcontroller로 바꿔보려한다. 
	  // spring 웹관련 설정파일인 servlet-context.xml 파일에서 적용 <view-controller path="/register/add" view-name="registerForm"/>
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // GET방식으로 접근불가
	@PostMapping("/add") // PostMapping POST방식으로만 접근가능 spring 4.3부터 사용가능
	public String save(@Valid User user, BindingResult result, Model m) throws Exception{ 
		System.out.println("result="+result);
		System.out.println("user="+user);
		
		// 수동 검증 - Validator를 직접 생성하고, validate()를 직접 호출
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result); // BindingResult는 Error의 자송
		
		// User객체를 검증한 결과 에러가 있으면, registerForm를 이용해서 에러를 보여줘야 함. 
		if(result.hasErrors()) {
			return "registerForm";
		}
//		// 1. 유효성 검사
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			return "forward:/register/add";
////			return "redirect:/register/add?msg="+msg; // URL재작성(rewriting) 위 두줄과 같다.
//		}
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
	return true;
	}
}
