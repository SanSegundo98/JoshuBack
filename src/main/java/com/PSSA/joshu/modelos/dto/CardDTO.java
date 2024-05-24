package com.PSSA.joshu.modelos.dto;

import lombok.Data;

@Data
public class CardDTO {
	private long cardID;
	private Long userID;
	private String toLearn;
	private String translation;
	private String example;
}
