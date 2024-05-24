package com.PSSA.joshu.servicios;

import com.PSSA.joshu.modelos.dto.CardDTO;

import java.util.List;

public interface ICardService {
	List<CardDTO> fetchCardsFromUser ( long userID );
}
