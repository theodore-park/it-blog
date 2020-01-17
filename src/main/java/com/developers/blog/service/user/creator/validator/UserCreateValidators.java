package com.developers.blog.service.user.creator.validator;

import com.developers.domain.user.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserCreateValidators {
	private final List<UserCreateValidator> userCreateValidators;

	public UserCreateValidators(List<UserCreateValidator> userCreateValidators) {
		this.userCreateValidators = userCreateValidators;
	}

	@Transactional(readOnly = true)
	public void validate(User user) {
		userCreateValidators.forEach(userCreateValidator -> userCreateValidator.validate(user));
	}
}
