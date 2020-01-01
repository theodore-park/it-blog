package com.developers.blog.controller.user;

import com.developers.blog.service.UserDto;
import com.developers.blog.service.UserService;
import com.developers.blog.service.creator.UserCreateRequest;
import com.developers.blog.service.creator.UserCreateService;
import com.developers.blog.service.updater.UserUpdateRequest;
import com.developers.blog.service.updater.UserUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	private final UserCreateService userCreateService;
	private final UserUpdateService userUpdateService;

	@GetMapping("users/{id}")
	public UserDto get(@PathVariable long id) {
		return userService.getUser(id);
	}

	@PostMapping("/users")
	public UserDto create(@RequestBody UserCreateRequest userCreateRequest) {
		return userCreateService.create(userCreateRequest);
	}

	@PutMapping("/users/{id}")
	public UserDto update(@PathVariable long id, @RequestBody UserUpdateRequest userUpdateRequest) {
		return userUpdateService.update(id, userUpdateRequest);
	}
}
