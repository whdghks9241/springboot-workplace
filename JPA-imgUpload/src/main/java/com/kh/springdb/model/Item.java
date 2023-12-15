package com.kh.springdb.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Item")
public class Item {
	//id name text price count stock isSoldout
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="items_seq")
	@SequenceGenerator(name="items_seq", sequenceName="items_seq", allocationSize=1)
	
	private int id;
	private String name;
	private String text;
	private String price;
	private int stock;
	private int isSoldout;
	
	//이미지 업로드를 위한 파일명, 이미지 경로, 상품 등록 날짜
	private String imgName;
	private String imgPath;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private LocalDate createDate;
	
	//DB에 값을 넣을 때 자동으로 생성된 날짜가 들어감 
	@PrePersist
	public void createDate() {
		this.createDate = LocalDate.now();
	}
	
	//판매자가 누구인지, 장바구니에 어떤 아이템이 들어가져 있는지 x
	
	
}
