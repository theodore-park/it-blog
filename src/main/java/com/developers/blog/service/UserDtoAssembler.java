package com.developers.blog.service;

import com.developers.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoAssembler {
	public UserDto assemble(User user) {
		return new UserDto(user.getId(), user.getName());
	}
}
