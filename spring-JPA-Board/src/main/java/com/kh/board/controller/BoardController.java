package com.kh.board.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.board.service.BoardService;
import com.kh.board.vo.Board;

@Controller
@RequestMapping("/Boards")
public class BoardController {

	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping
	public String getAllBoards(Model model) {
		List<Board> boards = boardService.getAllBoard();
		model.addAttribute("boards", boards);
		return "board_list";
	}
	
	@GetMapping("/detail/{id}")
	public String getProductById(@PathVariable Long id , Model model) {
		Optional<Board> board = boardService.getBoardById(id);
		board.ifPresent(value -> model.addAttribute("boards", value));
		return "board_detail";
	}
	
	//insert Get Post Mapping
	@GetMapping("/new")
	public String displayBoardForm(Model model) {
		model.addAttribute("board", new Board());
		return "board_form";
	}
	
	@PostMapping("/save")
	public String saveBoard(@ModelAttribute Board board) {
		boardService.saveBoard(board);
		return "redirect:/Boards";
	}
	
	// 수정하기
	@GetMapping("/update/{id}")
	public String getUpdateBoard(@PathVariable Long id, Model model) {
		Optional<Board> board = boardService.getBoardById(id);
		board.ifPresent(value -> model.addAttribute("board", value));
		return "board_form";
	}

	// delete @GetMapping
	@GetMapping("/delete/{id}")
	public String deleteBoard(@PathVariable Long id) {
		boardService.deleteBoardById(id);
		return "redirect:/Boards";
	}
	
	@GetMapping("/delete/all")
	public String deleteAllBoard() {
		boardService.deleteAllBoards();
		return "redirect:/Boards";
	}
}
