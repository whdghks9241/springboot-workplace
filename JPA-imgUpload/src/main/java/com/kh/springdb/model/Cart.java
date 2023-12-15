package com.kh.springdb.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cart {
	
	// 비회원 아이디 값 비회원이 주문한 장바구니 리스트
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cart_seq")
	@SequenceGenerator(name = "cart_seq", sequenceName="cart_seq",allocationSize=1)
	private Long Id;
	
	@OneToMany(mappedBy="cart" , cascade = CascadeType.ALL)
	private List<CartItem> cartItem = new ArrayList<>();

	/*
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cart_seq")
	@SequenceGenerator(name = "cart_seq", sequenceName="cart_seq",allocationSize=1)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user; // 구매자

    private int count; // 카트에 담긴 총 상품 개수

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems = new ArrayList<>();

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate; // 날짜

    @PrePersist
    public void createDate(){
        this.createDate = LocalDate.now();
    }

    public static Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setCount(0); // 장바구이네 상품 개수가 없기 때문에 0으로 초기화
        cart.setUser(user);
        return cart;
    }
	*/
}