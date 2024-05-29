package com.PSSA.joshu.controladores;

import com.PSSA.joshu.dao.ICardRepository;
import com.PSSA.joshu.dao.IUserRepository;
import com.PSSA.joshu.modelos.dto.CardDTO;
import com.PSSA.joshu.modelos.entidades.Card;
import com.PSSA.joshu.modelos.entidades.User;
import com.PSSA.joshu.servicios.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin("http://localhost:4200")
@Validated
public class CardController {
	private final ICardService ICardService;
	private final ICardRepository ICardRepository;
	private final IUserRepository IUserRepository;

	@Autowired
	public CardController ( ICardService ICardService, ICardRepository ICardRepository,
	                        IUserRepository IUserRepository ) {
		this.ICardService = ICardService;
		this.ICardRepository = ICardRepository;
		this.IUserRepository = IUserRepository;
	}

	@GetMapping("/{userID}")
	public ResponseEntity<List<CardDTO>> fetchCardsFromUser ( @PathVariable Long userID ) {
		List<CardDTO> cardsFromUser = ICardService.fetchCardsFromUser( userID );
		if ( !cardsFromUser.isEmpty() ) {
			return ResponseEntity.ok( cardsFromUser );
		} else {
			return ResponseEntity.status( 404 ).body( null );
		}
	}

	@PostMapping("/newCard/{userID}")
	public ResponseEntity<Card> newCard ( @RequestBody Card newCard, @PathVariable Long userID ) {
		
		User user = newCard.getUserID();
		user.setUserID( userID );
		newCard.setUserID( user );
		return new ResponseEntity<>( ICardRepository.save( newCard ), HttpStatus.CREATED );
	}
}