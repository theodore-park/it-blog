package com.developers.blog.service.creator.validator;

import com.developers.domain.user.User;
import com.developers.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DuplicateNameValidator implements UserCreateValidator {
	private final UserRepository userRepository;

	@Override
	public void validate(User user) {
		userRepository.findByName(user.getName()).ifPresent(duplicatedUser -> {
			log.warn("userId: {}", duplicatedUser.getId());
			throw new DuplicateNameException();
		});
	}
}
