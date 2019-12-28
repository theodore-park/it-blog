package com.developers.blog.service.updater;

import com.developers.blog.service.UserDto;
import com.developers.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUpdateService {
	private final UserRepository userRepository;

	public UserDto update(UserUpdateRequest userUpdateRequest) {
		return null;
	}
}
