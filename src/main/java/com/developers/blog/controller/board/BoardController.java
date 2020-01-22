package com.developers.blog.controller.board;

import com.developers.blog.service.board.BoardDto;
import com.developers.blog.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BoardController {
	private final BoardService boardService;

	@GetMapping("/boards")
	public List<BoardDto> get(PageRequest pageRequest) {
		return boardService.get(pageRequest);
	}

	@GetMapping("/boards/{id}")
	public BoardDto get(@PathVariable long id) {
		return boardService.get(id);
	}
}
