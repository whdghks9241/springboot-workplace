package com.kh.cafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.cafe.repository.CafeRepository;
import com.kh.cafe.vo.Cafe;

@Service
public class CafeService {
	private final CafeRepository cafeRepository;
	
	@Autowired
	public CafeService(CafeRepository cafeRepository) {
		this.cafeRepository = cafeRepository;
	}
	
	// 전체조회
	public List<Cafe> getAllCafe() {
		return cafeRepository.findAll();
	}

	// 특정상품 조회
	public Optional<Cafe> getCafeById(Long id) {
		return cafeRepository.findById(id);
	}
	
	// 게시물 추가하기
	public Cafe saveCafe(Cafe board) {
		return cafeRepository.save(board);
	}
	
	// 삭제
	public void deleteCafeById(Long id) {
		cafeRepository.deleteById(id);
	}
	
	
	// 모두삭제
	public void deleteAllCafes() {
		cafeRepository.deleteAll();
	}
	
	// 특정 검색어로 검색하는 메서드
	public List<Cafe> findCafeByName(String keyword) {
		return cafeRepository.findName(keyword);
	}
}
