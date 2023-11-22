package com.kh.springStart.springStart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroController {
	
	@RequestMapping("/into")
	public String getIntro() {
		return "Intro";
	}
}
