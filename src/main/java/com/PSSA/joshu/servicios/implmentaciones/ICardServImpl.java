package com.PSSA.joshu.servicios.implmentaciones;

import com.PSSA.joshu.dao.ICardRepository;
import com.PSSA.joshu.excepciones.NoCardsFoundExc;
import com.PSSA.joshu.modelos.dto.CardDTO;
import com.PSSA.joshu.modelos.entidades.Card;
import com.PSSA.joshu.modelos.mapeos.CardMapping;
import com.PSSA.joshu.servicios.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICardServImpl implements ICardService {
	private final ICardRepository cardRepo;

	@Autowired
	public ICardServImpl ( ICardRepository cardRepo ) {
		this.cardRepo = cardRepo;
	}

	@Override
	public List<CardDTO> fetchCardsFromUser ( long userID ) {
		List<Card> cardsFromUser = cardRepo.fetchCardsFromUser( userID );
		if ( cardsFromUser.isEmpty() ) {
			throw new NoCardsFoundExc( "No cards were found during the fetch." );
		}
		return cardsFromUser.stream().map( CardMapping::cardMapping ).toList();
	}
}
