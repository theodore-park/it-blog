package com.developers.blog.service.creator;

import com.developers.blog.service.UserDto;
import com.developers.blog.service.UserDtoAssembler;
import com.developers.blog.service.creator.validator.UserCreateValidators;
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
