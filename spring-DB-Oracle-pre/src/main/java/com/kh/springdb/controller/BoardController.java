package com.kh.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.kh.springdb.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardservice;
	@GetMapping("boardLists")
	public String displayBoardList(Model model) {
		
		model.addAttribute("boards", boardservice.getAllBoards());
		
		return "boardLists";
		
	}
	
}
