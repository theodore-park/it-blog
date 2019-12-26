package com.developers.blog.service.creator;

import com.developers.domain.user.User;
import com.developers.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserCreateTransactionService {
	private final UserRepository userRepository;

	@Transactional
	public void create(User user) {
		userRepository.save(user);
	}
}
