package com.kh.springdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.Comment;
import com.kh.springdb.model.Product;
import com.kh.springdb.repository.CommentRepository;
import com.kh.springdb.repository.ProductRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	// 댓글 추가 메서드
	public Comment addComment(int productId, String content) {
		Product product = productRepository.findById(productId).orElse(null);
		// 만약 상품이 존재하지 않을 경우 댓글 또한 존재하지 않으므로 댓글이 존재할 수 없을을 예외처리 함
		if (product == null) {
			throw new RuntimeException("찾는 상품은 존재하지 않습니다.");
		}
		
		// 댓글을 생성하기 위한 생서자 작성
		Comment comment = new Comment();
		comment.setProduct(product);
		comment.setContent(content);
		
		return commentRepository.save(comment);
	}
}
