package com.kh.board.controller;

import java.util.*;
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
import org.springframework.web.bind.annotation.RequestParam;

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


	// 특정 키워드를 활용해서 게시물 검색하는 Mapping 메서드
	@GetMapping("/search")
	public String searchBoards(@RequestParam String keyword, Model model) {
		// 특정 키워드를 포함해서 게시물 검색할 수 있더록 설정
		List<Board> boards = boardService.findBoardByTitle(keyword);
		
		// 모델에 검색 결과 추가
		model.addAttribute("boards", boards);
		// 검색 결과를 보여줄 페이지 리턴
		return "searchResult";
	}
}

/*

@RequestParam : Spring 프레임워크에서 클라이언트로 부터 전송된 http 요청의 파라미터 값을 받아오기 위해 사용되는 어노테이션
				주로 웹 요청에서 쿼리 파라미터나 폼 데이터를 추출하는데 사용
				클라이언트가 전송한 요청의 파라미터 값을 메서드의 매개변수로 받아올 떄 사용

	예제코드 :
		@GetMapping("/ex")
		public String paramMathod(@RequestParam String name, @RequestParam int age) {
			// name과 age는 클라이언트가 전송한 요청의 쿼리 파라미터 값
			return "VIew";
		}
		
		
	조회 : 전체조회(findAll) 아이디 하나만 조회 (findById) findOne
					저장 : save
					삭제 : deleteById
					
	findOne : 조건에 해당하는 엔터티 중에서 첫 번째 엔터티만 반환
			  조건에 해당하는 언터티가 없으면 null 반환
	
	findById : 일반적으로 프라이머리 키에 해당하는 엔터티를 찾아서 반환
			   Optional Optional.empty() = 빈 값으로 반환 처리를 할 수 있음
			   JPA 2.0 이후로 출시된 findOne보다는 최신번전

*/
