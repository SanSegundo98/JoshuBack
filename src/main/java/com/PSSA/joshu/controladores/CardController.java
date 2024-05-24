package com.PSSA.joshu.controladores;

import com.PSSA.joshu.modelos.dto.CardDTO;
import com.PSSA.joshu.servicios.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:4200")
@Validated
public class CardController {
	private final ICardService ICardService;

	@Autowired
	public CardController ( ICardService ICardService ) {
		this.ICardService = ICardService;
	}

	@GetMapping("/{userID}")
	public ResponseEntity<List<CardDTO>> fetchCardsFromUser ( @PathVariable long userID ) {
		List<CardDTO> cardsFromUser = ICardService.fetchCardsFromUser( userID );
		if ( !cardsFromUser.isEmpty() ) {
			return ResponseEntity.ok( cardsFromUser );
		} else {
			return ResponseEntity.status( 404 ).body( null );
		}
	}

}