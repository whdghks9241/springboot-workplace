package com.kh.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.board.repository.BoardRepository;
import com.kh.board.vo.Board;

@Service
public class BoardService {

	private final BoardRepository boardRepository;
	
	@Autowired
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	// 전체조회
	public List<Board> getAllBoard() {
		return boardRepository.findAll();
	}
	
	// 특정상품 조회
	public Optional<Board> getBoardById(Long id) {
		return boardRepository.findById(id);
	}
	
	// 게시물 추가하기
	public Board saveBoard(Board board) {
		return boardRepository.save(board);
	}
	
	// 삭제
	public void deleteBoardById(Long id) {
		boardRepository.deleteById(id);
	}
	
	
	// 모두삭제
	public void deleteAllBoards() {
		boardRepository.deleteAll();
	}
	
	// 특정 검색어로 검색하는 메서드
	public List<Board> findBoardByTitle(String keyword) {
		return boardRepository.findTitle(keyword);
	}
	
}
