package com.kh.springdb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

	//모든 카트에 담긴 아이템을 반환하는 리스트
	List<CartItem> findCartItemByItemId(int id);

	//Id 값에 해당하는 아이템을 찾는 메서드
	CartItem findCartItemById(int id);
	
	//CartId와 itemId로 CartItem 찾는 메서드
	List<CartItem> findByItemId(int itemId);
}
