package com.developers.blog.controller.board;

import com.developers.blog.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
}
