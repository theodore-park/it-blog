package com.developers.blog.service.board;

public class BoardNotFoundException extends RuntimeException {
	public BoardNotFoundException() {
		super("해당 글을 찾을 수 없습니다.");
	}
}
