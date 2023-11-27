package com.kh.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springdb.model.Board;

@Mapper
public interface BoardMapper {

	// 모든 게시물 조회
	List<Board> getAllBoards();
	
	// 게시물 1개 조회
	Board getBoardById(int boardId);
	
	// 게시물 저장하기
	void insertBoard(Board board);
	
	// 게시물 수정하기
	void updateBoard(Board board);
	
	// 게시물 삭제하기
	void deleteBoard(int boardId);
	
	// 게시물 모두 삭제하기
	void deleteAllBoards();
}
