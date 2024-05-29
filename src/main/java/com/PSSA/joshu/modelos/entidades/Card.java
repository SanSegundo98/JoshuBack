package com.PSSA.joshu.modelos.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "cards")
@Data
@NoArgsConstructor
public class Card implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(unique = true)
	private long cardID;

	@Column(nullable = false)
	private String toLearn;

	@Column(nullable = false)
	private String translation;

	@Column
	private String example;

	@ManyToOne
	@JoinColumn(name = "userID")
	private User userID;
}