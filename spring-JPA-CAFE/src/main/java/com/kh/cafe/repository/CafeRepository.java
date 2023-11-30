package com.kh.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.cafe.vo.Cafe;


public interface CafeRepository  extends JpaRepository<Cafe, Long>{
	@Query("SELECT c FROM Cafe c WHERE c.name LIKE %:keyword%")
//    List<Cafe> findName(@Param("keyword") String keyword);
	List<Cafe> findName(String keyword);
}

/*
  Query Creation : Spring Data JPA 에서 제공하는 기능
  메서드에 규칙이 존재하고 규칙에 따라서 메서드를 생성해주는 기능
  메서드 이름으로 데이터베이스 쿼리를 생성

 findBy + 내가 적고싶은 변수명
  ex) 
  지역검색
  	findBylocation(String location)
	-> SELECT * FROM Cafe WHERE location = ?
	
	findByNameContaining(String keyword);
	Containing => 해당하는 변수명이 특정 변수에 대한 검색을 Like로 진행할 수 있게 도와줌
	
  운영시간
  	findByOpeningHours(String OpeningHours)
	-> SELECT * FROM Cafe WHERE OpeningHours = ?

  총 갯수를 계산해주는 메서드
  countBy + 클래스에 적어둔 변수명
	countByLocation(String location)
	-> SELECT COUNT(*) FROM Cafe WHERE location = ?
	
  존재여부를 확인해주는 메서드를 만들고 싶다면
  existsBy + 클래스에 적어둔 변수명
  	existsByLocation(String location)
 	-> SELECT CASE WHEN COUNT(*) > 0 THEN true 
 		ELSE false END FROM Cafe WHERE location = ?
  
  삭제를 원한다면
  deleteBy + 클레스에 적어둔 변수명 	
 	deleteByLocation(String Location)
 	-> DELETE FROM Cafe WHERE location = ?
 */