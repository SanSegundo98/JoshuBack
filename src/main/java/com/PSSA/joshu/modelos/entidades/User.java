package com.PSSA.joshu.modelos.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User implements Serializable {

	public User ( Long id ) {
		this.userID = id;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(unique = true)
	private Long userID;

	@Column(nullable = false, unique = true)
	private String password;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String username;

	@Column(unique = true)
	private String loginToken;

}
