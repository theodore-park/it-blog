package com.developers.blog.service.board;

import com.developers.domain.board.Board;
import org.springframework.stereotype.Component;

@Component
public class BoardDtoAssembler {
	public BoardDto assemble(Board board) {
		return BoardDto.builder()
			.id(board.getId())
			.title(board.getTitle())
			.contents(board.getContents())
			.views(board.getViews())
			.createdAt(board.getCreatedAt())
			.updatedAt(board.getUpdatedAt())
			.build();
	}
}
