package com.PSSA.joshu.servicios;

import com.PSSA.joshu.modelos.dto.UserDTO;

public interface IUserService {
	UserDTO fetchUser ( String username );

}
