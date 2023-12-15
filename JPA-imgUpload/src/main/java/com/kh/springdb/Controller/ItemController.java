package com.kh.springdb.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.Service.ItemService;
import com.kh.springdb.model.Item;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {
	private final ItemService itemService;
	
	//메인페이지
	@GetMapping("/")
	public String mainPage(Model model) {
		List<Item> items = itemService.allItemView();
		model.addAttribute("items", items);
		return "index";
	}
	//상품 전체 목록 페이지로 이동하기 위한 GetMapping
	@GetMapping("/item/list")
	public String itemList(Model model) {
		List<Item> items = itemService.allItemView();
		model.addAttribute("items", items);
		return "itemList";
	}
	//상품 등록 페이지로 이동하기 위한 GetMapping
	@GetMapping("/item/new")
	public String itemSaveForm(Model model) {
		return "addItemForm";
	}
	
	// 클라언트가 등록한 상품 등록 내용을 DB에 업로드
	@PostMapping("/item/new")
	public String itemSave(Item item, MultipartFile imgFile) throws IllegalStateException, IOException {
		itemService.saveItem(item, imgFile);
		return "redirect:/";
	}
}