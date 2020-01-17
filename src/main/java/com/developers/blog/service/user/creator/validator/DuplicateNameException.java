package com.developers.blog.service.user.creator.validator;

public class DuplicateNameException extends RuntimeException {
	public DuplicateNameException() {
		super("이미 등록된 이름이 있습니다.");
	}
}
