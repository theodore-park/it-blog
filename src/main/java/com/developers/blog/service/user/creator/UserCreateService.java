package com.developers.blog.service.user.creator;

import com.developers.blog.service.user.UserDto;
import com.developers.blog.service.user.UserDtoAssembler;
import com.developers.blog.service.user.creator.validator.UserCreateValidators;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateService {
	private final UserCreateValidators userCreateValidators;
	private final UserCreator userCreator;
	private final UserCreateTransactionService userCreateTransactionService;
	private final UserDtoAssembler userDtoAssembler;

	public UserDto create(UserCreateRequest userCreateRequest) {
		var user = userCreator.create(userCreateRequest);
		userCreateValidators.validate(user);
		userCreateTransactionService.create(user);
		return userDtoAssembler.assemble(user);
	}
}
