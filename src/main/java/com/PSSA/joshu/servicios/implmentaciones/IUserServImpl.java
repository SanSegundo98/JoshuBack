package com.PSSA.joshu.servicios.implmentaciones;

import com.PSSA.joshu.dao.IUserRepository;
import com.PSSA.joshu.excepciones.NoUsersFoundExc;
import com.PSSA.joshu.modelos.dto.UserDTO;
import com.PSSA.joshu.modelos.entidades.User;
import com.PSSA.joshu.modelos.mapeos.UserMapping;
import com.PSSA.joshu.servicios.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServImpl implements IUserService {
	private final IUserRepository IUserRepository;
	private final UserMapping userMapping;

	@Autowired
	public IUserServImpl ( IUserRepository userRepo, UserMapping userMapping ) {
		this.IUserRepository = userRepo;
		this.userMapping = userMapping;
	}

	@Override
	public UserDTO fetchUser ( String username ) {
		User user = IUserRepository.fetchUser( username );
		if ( user == null ) {
			throw new NoUsersFoundExc( "No user was found during the fetch." );
		}
		return userMapping.userMapping( user );
	}
	
}