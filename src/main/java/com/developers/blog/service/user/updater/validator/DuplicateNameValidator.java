package com.developers.blog.service.user.updater.validator;

import com.developers.domain.user.User;
import com.developers.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DuplicateNameValidator implements UserUpdateValidator{
	private final UserRepository userRepository;

	@Override
	public void validate(User user) {
	}
}
