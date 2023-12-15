package com.kh.oracleDB.mallBoard.Controller;

import com.kh.oracleDB.mallBoard.model.vo.Item;
import com.kh.oracleDB.mallBoard.service.ItemService;

import lombok.*;

import java.util.*;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequiredArgsConstructor
// @NotNull로 표시된 필드를 사용해서 생성자를 생성
public class ItemController {
	
	private final ItemService itemService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
//		List<Item> items = itemService.allItemList();
//		model.addAttribute("items", items);
		return "/index";
	}
	
	/*
	@GetMapping("/item/list")
	public String itemList(Model model, @PageableDefault(size=12) Pageable pageable, @RequestParam(name="keyowrd", required = false) String keyword) {
		// 페이지 네이션 처리를 위한 서비스
		// 검색을 하지 않고 페이징 처리를 원할경우	
		// Page<Item> items = itemService.getItemByPage(pageable);
		
		return "itemList";
	}
	*/
	// @GetMapping 상품등록 페이지 // admin만 등록할 수 있게 수정
	@GetMapping("/new")
	public String addItemForm(Model model) {
		return "addItemForm.html";
	}

	// @PostMapping 상품 등록으로 입력된 값을 DB에 보내기 // admin만 등록할 수 있게 수정
	@PostMapping("/save")
	public String saveItem(Item item, MultipartFile photoFile) {
		// NultipartFile을 이용해서 상품을 등록할 때 이미지 파일도 같이 등록될 수 있도록 파라미터 생성
		// itemService.addItem(item);
		// 이미지 없이 상품을 등록하고 싶다면 item만 작성해도되지만
		// 이미지를 포함한 상품을ㄷ ㅡㅇ록하고 싶다면 item, photoFile을 추가해서 작성
		return "redirect:/itemList";
	}
	
	// 상세
	@GetMapping("/view/{id}")
	public String viewItem(Model model, @PathVariable("id") Integer id) {
//		model.addAttribute("item", itemService.getItemById(id));
		return "viewItem";
	}
	
	// 수정
	
	// 삭제
	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") Integer id) {
//		itemService.itemDelete(id);
		return "itemList";
	}
}
