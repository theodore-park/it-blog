package com.developers.blog.controller.user;

import com.developers.blog.service.UserDto;
import com.developers.blog.service.creator.UserCreateRequest;
import com.developers.blog.service.creator.UserCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserCreateService userCreateService;

	@PostMapping("/users")
	public UserDto create(@RequestBody UserCreateRequest userCreateRequest) {
		return userCreateService.create(userCreateRequest);
	}
}
