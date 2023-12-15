package com.kh.oracleDB.mallBoard.model.vo;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cartItem_seq")
	@SequenceGenerator(name = "cartItem_seq", sequenceName="cartItem_seq",allocationSize=1)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="item_id")
    private Item item;

    private int count; // 상품 개수

    public static CartItem createCartItem(Cart cart, Item item, int amount) {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setItem(item);
        cartItem.setCount(amount);
        return cartItem;
    }

    // 이미 담겨있는 물건 또 담을 경우 수량 증가
    public void addCount(int count) {
        this.count += count;
    }

}
/*
Cart : 사용자가 담거나 주문한 상품들을 담아두는 역할
현재 -> User 연결을 해주지 않아서 큰 의미는 없지만 추후 User와 연결하게 되면 User - Cart와 연관 관계가 생길 예정

CartItem : 카트에 담긴 각 상품의 정보를 포함. 개별 상품들을 나타냄
카트 아이템이 실질적으로 장바구니 역할을 함


@ManyToOne(fetch=FetchType.EAGER)
여러 엔티티가 하나의 엔티티에 감싸져서 활용되는 N:1 관계를 나타냄
fetch=FetchType.EAGER : 가져오기, 감싸진(매핑된) 엔티티를
자바에서 검색할 때(찾고자할 때) 바로 로딩해서 가져올 수 있도록 설정해준 것

 * */