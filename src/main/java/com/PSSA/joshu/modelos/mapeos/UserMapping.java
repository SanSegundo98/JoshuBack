package com.PSSA.joshu.modelos.mapeos;

import com.PSSA.joshu.modelos.dto.UserDTO;
import com.PSSA.joshu.modelos.entidades.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class UserMapping {
	public UserDTO userMapping ( User user ) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserID( user.getUserID() );
		userDTO.setUsername( user.getUsername() );
		userDTO.setPassword( user.getPassword() );
		return userDTO;
	}
}