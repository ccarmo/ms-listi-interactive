package com.dev.clibank.domain.repository;

import com.dev.clibank.domain.entities.Card;

import java.io.FileNotFoundException;
import java.util.Optional;

public interface CardRepository {
    Optional<Card> getNumberCard(String numberCard);
    
}
