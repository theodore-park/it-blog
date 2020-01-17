package com.developers.blog.service.user;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
		super("해당 고객을 찾을 수 없습니다.");
	}
}
