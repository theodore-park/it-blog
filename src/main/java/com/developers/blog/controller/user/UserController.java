package com.developers.blog.controller.user;

import com.developers.blog.service.UserDto;
import com.developers.blog.service.UserService;
import com.developers.blog.service.creator.UserCreateRequest;
import com.developers.blog.service.creator.UserCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	private final UserCreateService userCreateService;

	@GetMapping("users/{id}")
	public UserDto get(@PathVariable long id) {
		return userService.getUser(id);
	}

	@PostMapping("/users")
	public UserDto create(@RequestBody UserCreateRequest userCreateRequest) {
		return userCreateService.create(userCreateRequest);
	}
}
