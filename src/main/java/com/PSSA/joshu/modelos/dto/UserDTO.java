package com.PSSA.joshu.modelos.dto;

import lombok.Data;

@Data
public class UserDTO {
	private String username;
	private String password;
	private String email;
	private Long userID;
}
