package com.developers.blog.service.board;

import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
public class BoardDto {
	private long id;
	private String title;
	private String contents;
	private long views;
	private OffsetDateTime createdAt;
	private OffsetDateTime updatedAt;

	@Builder
	public BoardDto(long id, String title, String contents, long views, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.views = views;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
