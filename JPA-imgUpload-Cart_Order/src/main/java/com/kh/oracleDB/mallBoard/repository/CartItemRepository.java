package com.kh.oracleDB.mallBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.oracleDB.mallBoard.model.vo.CartItem;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	//CartId와 itemId로 CartItem 찾는 메서드
	CartItem findByCartIdAndItemId(int carItd, 
								int itemId);
	//Id 값에 해당하는 아이템을 찾는 메서드
	CartItem findCartItemById(int id); //cartItem.cartItem_id
	
	//모든 카트에 담긴 아이템을 반환하는 리스트
	List<CartItem> findCartItemByItemId(int id);
	
}