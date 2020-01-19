package com.developers.blog.service.board;

import com.developers.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	private final BoardDtoAssembler boardDtoAssembler;

	public List<BoardDto> get(Pageable pageable) {
		return boardRepository.findAll(pageable)
			.stream()
			.map(boardDtoAssembler::assemble)
			.collect(Collectors.toList());
	}

	public BoardDto get(long id) {
		return boardRepository.findById(id)
			.map(boardDtoAssembler::assemble)
			.orElseThrow(BoardNotFoundException::new);
	}
}
