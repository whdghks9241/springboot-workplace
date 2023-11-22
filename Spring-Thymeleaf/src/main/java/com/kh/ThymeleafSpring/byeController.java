package com.kh.ThymeleafSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class byeController {

	@GetMapping("/bye")
	public String hello(Model model) {
		model.addAttribute("message", "잘가 thymeLeat야");
		return "bye";
	}
}
