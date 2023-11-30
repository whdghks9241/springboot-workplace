package com.kh.cafe.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.kh.cafe.service.CafeService;
import com.kh.cafe.vo.Cafe;

@Controller
@RequestMapping("/cafes")
public class CafeController {

	private final CafeService cafeService;
	
	@Autowired
	public CafeController(CafeService cafeService) {
		this.cafeService = cafeService;
	}
	
	// 전체조회
	@GetMapping
	public String getAllCafes(Model model, @RequestParam(required=false) String name) {
		// @RequestParam(required=false) : 파라미터를 필수로 적어주지 않아도 된다.
		// @RequestParam http 요청으로 파라미터를 메서드의 매개변수로 전달할 때
		// 클라이언트가 웹 애플리케이션에 보내는 요청의 파라마터값을 받아서 처리하는데 사용
		List<Cafe> cafes;
		// 리스트를 만들어준 후
		// 만약에 리스트에서 카페가 존재한다면 그 카페목록들만 보여주고 존재하지 않는다면 모든 카페 내용을 보여준다
		// 만약 카페 이름 값이 빈 값이 아니거나 null 값이 아니라면
		if (name != null && !name.isEmpty()) {
			// 사람들이 검색한 카패 내용을 service에서 가져와서 뿌린다음 cafes에 넣는다
			cafes = cafeService.findCafeByName(name);
		} else {
			// 모든 카페 리시트를 보여준다.
			cafes = cafeService.getAllCafe();
		}
		
		model.addAttribute("cafes", cafes);
		return "cafe_list";
	}
	
	@GetMapping("/detail/{id}")
	public String getProductById(@PathVariable Long id , Model model) {
		Optional<Cafe> board = cafeService.getCafeById(id);
		board.ifPresent(value -> model.addAttribute("cafes", value));
		return "cafe_detail";  
	}
	
	//insert Get Post Mapping
	@GetMapping("/new")
	public String displayCafeForm(Model model) {
		model.addAttribute("cafe", new Cafe());
		return "cafe_form";
	}
	
	@PostMapping("/save")
	public String saveCafe(@ModelAttribute Cafe board) {
		cafeService.saveCafe(board);
		return "redirect:/cafes";
	}
	
	// 수정하기
	@GetMapping("/update/{id}")
	public String getUpdateBoard(@PathVariable Long id, Model model) {
		Optional<Cafe> board = cafeService.getCafeById(id);
		board.ifPresent(value -> model.addAttribute("cafe", value));
		return "cafe_form";
	}

	// delete @GetMapping
	@GetMapping("/delete/{id}")
	public String deleteCafe(@PathVariable Long id) {
		cafeService.deleteCafeById(id);
		return "redirect:/cafes";
	}
	
	@GetMapping("/delete/all")
	public String deleteAllcafe() {
		cafeService.deleteAllCafes();
		return "redirect:/cafes";
	}

/*
	// 특정 키워드를 활용해서 게시물 검색하는 Mapping 메서드
	@GetMapping("/search")
	public String searchCafes(@RequestParam String keyword, Model model) {
		// 특정 키워드를 포함해서 게시물 검색할 수 있더록 설정
		List<Cafe> cafes = cafeService.findCafeByName(keyword);
		
		// 모델에 검색 결과 추가
		model.addAttribute("cafes", cafes);
		// 검색 결과를 보여줄 페이지 리턴
		return "cafe_search";
	}


	@PathVariable  @RequestParam 차이점
	
	PathVariable : URL 경로에서 변수 값을 추출 url / cafes/{id}
	RequestParam : 한 경로 안에서 클라이너트가 요청한 파라미터 값을 추출 url /cafes?name=사용자가 폼에 입력한 값
	
	
	
	
	
	*/
}

