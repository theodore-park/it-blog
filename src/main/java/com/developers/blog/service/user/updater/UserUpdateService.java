package com.developers.blog.service.user.updater;

import com.developers.blog.service.user.UserDto;
import com.developers.blog.service.user.UserDtoAssembler;
import com.developers.blog.service.user.UserNotFoundException;
import com.developers.blog.service.user.updater.validator.UserUpdateValidators;
import com.developers.domain.user.User;
import com.developers.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUpdateService {
	private final UserRepository userRepository;
	private final UserUpdateValidators validators;
	private final UserDtoAssembler userDtoAssembler;

	public UserDto update(long userId, UserUpdateRequest userUpdateRequest) {
		User user = getUser(userId);
		update(user, userUpdateRequest);
		validators.validate(user);
		return userDtoAssembler.assemble(user);
	}

	private void update(User user, UserUpdateRequest userUpdateRequest) {
		user.setName(userUpdateRequest.getName());
	}

	private User getUser(long userId) {
		return userRepository.findById(userId)
			.orElseThrow(UserNotFoundException::new);
	}
}
