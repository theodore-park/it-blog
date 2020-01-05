package com.developers.blog.service.deleter;

import com.developers.blog.service.UserNotFoundException;
import com.developers.domain.user.User;
import com.developers.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDeleteService {
	private final UserRepository userRepository;

	@Transactional
	public void delete(long id) {
		User user = getUser(id);
		userRepository.delete(user);
	}

	private User getUser(long id) {
		return userRepository.findById(id)
			.orElseThrow(UserNotFoundException::new);
	}
}
