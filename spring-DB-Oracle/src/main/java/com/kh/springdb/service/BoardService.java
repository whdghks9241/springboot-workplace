package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springdb.mapper.BoardMapper;
import com.kh.springdb.model.Board;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	// 게시판에서 게시물 전체보기
	public List<Board> getAllBoards() {
		return boardMapper.getAllBoards();
	}
	
	// 게시판에서 게시물 1개 선택후 상세보기	
	public Board getBoardById(int boardId) {
		return boardMapper.getBoardById(boardId);
	}

	// 게시판에서 게시글 작성하기
	public void insertBoard(Board board) {
		boardMapper.insertBoard(board);
	}
	
	// 게시판에서 게시글 수정하기
	public void updateBoard(Board board) {
		boardMapper.updateBoard(board);
	}

	//게시판에서 게시글 삭제하기 Service
	public void deleteBoard(int boardId) {
		boardMapper.deleteBoard(boardId);
		
	}
	//게시물 모두 삭제
	@Transactional
	public void deleteAllBoards() {
		boardMapper.deleteAllBoards();
	}

}

/*
 @Transactional 
 	트랜잭션을 지원하는 스프링에서 데이터베이스 관리를 단순히 어노테이션을 사용해서 여러개의 데이터베이스 조작 작업을 묶어서 하나의 작업단위로 처리하는데 사용하며
 	작업은 성공 또는 실패로 완료될 수 있음
 	개발자가 일일이 커밋 또는 롤백을 관리하는 코드를 작성하지 않아도 됨.
 
 
 */
