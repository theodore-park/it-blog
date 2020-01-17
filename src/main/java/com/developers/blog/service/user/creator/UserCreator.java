package com.developers.blog.service.user.creator;

import com.developers.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserCreator {
	public User create(UserCreateRequest userCreateRequest) {
		return new User(userCreateRequest.getName());
	}
}
