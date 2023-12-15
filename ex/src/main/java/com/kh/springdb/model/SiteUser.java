package com.kh.springdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@SequenceGenerator(name = "users_seq", sequenceName="users_seq", allocationSize=1)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private UserRole isRole;
	//private String isRole;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	@Column(unique = true)
	private String email;
	

	
	// 추천인을 넣고 싶다면 추천자를 생성해서 넣어도 됨
}
