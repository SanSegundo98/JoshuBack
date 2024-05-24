package com.PSSA.joshu.controladores;

import com.PSSA.joshu.dao.IUserRepository;
import com.PSSA.joshu.modelos.dto.UserDTO;
import com.PSSA.joshu.modelos.entidades.User;
import com.PSSA.joshu.servicios.IUserService;
import com.PSSA.joshu.utilities.PasswordEncoder;
import com.PSSA.joshu.utilities.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
@Validated
public class UserController {
	private final IUserService IUserService;
	private final IUserRepository IUserRepository;

	@Autowired
	public UserController ( IUserService IUserService, IUserRepository IUserRepository ) {
		this.IUserService = IUserService;
		this.IUserRepository = IUserRepository;
	}

	@GetMapping("/{username}/{password}")
	public ResponseEntity<UserDTO> fetchUser ( @PathVariable String username, @PathVariable String rawPassword ) {

		UserDTO user = IUserService.fetchUser( username );
		if ( user != null && PasswordEncoder.matches( rawPassword, user.getPassword() ) ) {
			return ResponseEntity.ok( user );
		} else {
			return ResponseEntity.status( 404 ).body( null );
		}
	}

	@PostMapping("/newUser")
	public ResponseEntity<User> newUser ( @RequestBody User newUser ) {
		String encodedPass = PasswordEncoder.encodePassword( ( newUser.getPassword() ) );
		newUser.setLoginToken( TokenGenerator.generateToken() );
		newUser.setPassword( encodedPass );
		return new ResponseEntity<>( IUserRepository.save( newUser ), HttpStatus.CREATED );
	}

}
