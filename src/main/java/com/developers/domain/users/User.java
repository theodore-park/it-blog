package com.developers.domain.users;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;
}
