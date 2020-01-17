package com.developers.blog.controller.user;

import com.developers.blog.service.user.UserDto;
import com.developers.blog.service.user.UserService;
import com.developers.blog.service.user.creator.UserCreateRequest;
import com.developers.blog.service.user.creator.UserCreateService;
import com.developers.blog.service.user.deleter.UserDeleteService;
import com.developers.blog.service.user.updater.UserUpdateRequest;
import com.developers.blog.service.user.updater.UserUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	private final UserCreateService userCreateService;
	private final UserUpdateService userUpdateService;
	private final UserDeleteService userDeleteService;

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

	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable long id) {
		userDeleteService.delete(id);
	}
}
