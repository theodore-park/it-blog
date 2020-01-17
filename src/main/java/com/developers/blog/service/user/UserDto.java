package com.developers.blog.service.user;

import lombok.Getter;

@Getter
public class UserDto {
	private long id;
	private String name;

	public UserDto(long id, String name) {
		this.id = id;
		this.name = name;
	}
}
