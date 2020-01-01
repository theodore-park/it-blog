package com.developers.blog.service.updater.validator;

import com.developers.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserUpdateValidators {
	private final List<UserUpdateValidator> validators;

	public UserUpdateValidators(List<UserUpdateValidator> validators) {
		this.validators = validators;
	}

	public void validate(User user) {
		validators.forEach(validator -> validator.validate(user));
	}
}
