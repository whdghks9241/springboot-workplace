package com.kh.springprojectchap1.web;

public class NewFileControler {
	// html jsp view 공간과 db 연결하는 역할
	// 파일 경로를 설정할 때
	// 항상 run하는 java 파일 하위 폴더에 설정
	// 만약에 하위로 두지 않고 따로 만들어서 사용할 경우에는
	// 폴더를 바라보는 위치를 별로도 지정해줘야한다.
//	@GetMapping
	public String hello() {
		return "Hello, world";
	}
}
