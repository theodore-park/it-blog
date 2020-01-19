package com.developers.blog.service.board;

import com.developers.domain.board.BoardRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
	private BoardRepository boardRepository;
	private BoardDtoAssembler boardDtoAssembler;

	public List<BoardDto> get(Pageable pageable) {
		return boardRepository.findAll(pageable)
			.stream()
			.map(boardDtoAssembler::assemble)
			.collect(Collectors.toList());
	}

}
