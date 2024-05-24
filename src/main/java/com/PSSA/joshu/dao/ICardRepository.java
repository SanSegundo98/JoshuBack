package com.PSSA.joshu.dao;

import com.PSSA.joshu.modelos.entidades.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICardRepository extends JpaRepository<Card, Long> {
	@Query(value = "SELECT * FROM cards WHERE userID = :userID ", nativeQuery = true)
	List<Card> fetchCardsFromUser ( @Param("userID") Long userID );

	@Query(value = "INSERT INTO cards (toLearn, translation, example) VALUES (:toLearn, :translation, :example)",
			nativeQuery = true)
	Card saveNewCard ( @Param("toLearn") String toLearn, @Param("translation") String translation,
	                   @Param("example") String example );
}
