package com.kh.springPJ;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {

	@GetMapping("intro")
	public String getIntro() {
		return "intro";
	}
}
