package com.developers.blog.service;

import com.developers.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final UserDtoAssembler userDtoAssembler;

	public UserDto getUser(long id) {
		return userRepository.findById(id)
			.map(userDtoAssembler::assemble)
			.orElseThrow(UserNotFoundException::new);
	}
}
