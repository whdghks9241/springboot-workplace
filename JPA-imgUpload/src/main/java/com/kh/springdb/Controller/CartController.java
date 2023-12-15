package com.kh.springdb.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.Service.CartService;
import com.kh.springdb.Service.ItemService;
import com.kh.springdb.model.Cart;
import com.kh.springdb.model.Item;

@Controller
@RequestMapping("cart")
public class CartController {
	private final CartService cartService;
	private final ItemService itemService;
	
	public CartController(CartService cartService, ItemService itemService) {
		this.cartService = cartService;
		this.itemService = itemService;
	}
	
	// 장바구니 목록 보여주기 위한 GetMapping
	public String viewCart(Model model) {
		Cart cart = cartService.getCartById(1L);
		model.addAttribute("cart", cart);
		return "cartView";
	}
	
	// 주소를 접속하기 위해서 GetMapping
	@GetMapping("/add/{itemid}")
	public String addToCart(@PathVariable int itemId, Model model) {
		
		Item newItem = itemService.getItemById(itemId);
		// @PathVariable Long itemId
		// Item newItem = itemService.getItemById(itemId.inValue());
		cartService.addCart(1L, newItem, 1);
		
		return "redirect:/cart";
	}
}
