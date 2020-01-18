package com.developers.domain.board;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Getter
@Entity
@Table(name = "boards")
public class Board {
	@Id
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "contents")
	private String contents;

	@CreationTimestamp
	@Column(name = "created_at")
	private OffsetDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private OffsetDateTime updatedAt;
}
