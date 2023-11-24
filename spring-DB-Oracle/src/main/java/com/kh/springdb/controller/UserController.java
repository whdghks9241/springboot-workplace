package com.kh.springdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.springdb.model.User;
import com.kh.springdb.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	// 전체 아이디를 가져오기 위해서 GetMapping 사용
	@GetMapping("users-infomation")
	public String getAllUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
 		return "users-infomation";
	}
	
	// 하나의 아이디 가져오기
	@GetMapping("user-info/{id}")
	public String getUserById(@PathVariable int id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "user-info";
	}
	
	@GetMapping("/registerSuccess")
	public String getRegisterSuccess() {
		return "registerSuccess";
	}
	
	@PostMapping("/api/user/register")
	public String registerMember(@ModelAttribute("user")  @Validated User user, BindingResult result) {
		userService.registerUser(user);
		//유저가 회원가입을 성공할 경우 이동하는 경로
		return "redirect:/registerSuccess";
	}
	
	@GetMapping("register")
	public String register(Model model) {

		model.addAttribute("user", new User());
		return "register";
	}
}

/*
 @PathVariable : 경로에 대한 변수를 메서드의 매개변수로 받을 때 사용
 사용법 :  @PathVariable int id
 	{id} 
 
 
 @ModelAttribute("값")
 	Thyeleaf 뷰에서 설정한 값의 이름을 사용해서 모델 속성에 엑서스 할 수 있음
 	엑서스(access) : 컴퓨터 데이터 또는 리소스를 어떤 방식으로든 사용할 수 있도록 권한을 주거나 권한이 담겨진 것을 의미
 	
 	@ModelAttribute("user") : user라는 이름으로 Model에 User 객체를 추가한 것
 	
 @Validated : 데이터 유효성 검사를 실시하도록 행하는 것
 	@Validated(user) : User 객체에 대한 데이터 유효성 검사를 실시하겠다 한 것
 	
 @BindingResult : @Validated 실시한 유효성 검사 결과를 저장하는 객체
 				  유효성 검사에서 발생한 오류에 대한 정보를 담기는 고악ㄴ
 
 
 
 
 */