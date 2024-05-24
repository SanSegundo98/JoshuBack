package com.PSSA.joshu.modelos.mapeos;

import com.PSSA.joshu.modelos.dto.CardDTO;
import com.PSSA.joshu.modelos.entidades.Card;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class CardMapping {
	public static CardDTO cardMapping ( Card card ) {
		CardDTO cardDTO = new CardDTO();
		cardDTO.setCardID( card.getCardID() );
		cardDTO.setToLearn( card.getToLearn() );
		cardDTO.setTranslation( card.getTranslation() );
		cardDTO.setExample( card.getExample() );

		return cardDTO;
	}
}
