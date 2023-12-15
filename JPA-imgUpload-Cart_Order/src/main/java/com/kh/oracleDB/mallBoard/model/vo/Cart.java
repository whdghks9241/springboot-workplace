package com.kh.oracleDB.mallBoard.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.*;


@Builder//객체를 불변하게 잡아주는 역할을 함
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cart {
/*
 @NoArgsConstructor
 public class Cart() {
 }
 
 @AllArgsConstructor
 public class Cart(int id,User user,int count,  List<CartItem> cartItems,LocalDate createDate){
 this.id = id;
 this.user = user;
 this.count = count;
 this.cartItems = cartItems;
 this.createDate = createDate;
 }

 * */

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
        cart.setCount(0);
        cart.setUser(user);
        return cart;
    }

}