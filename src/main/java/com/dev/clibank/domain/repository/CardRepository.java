package com.dev.clibank.domain.repository;

import com.dev.clibank.domain.entities.Card;

import java.io.FileNotFoundException;

public interface CardRepository {
    void get(Card card) throws FileNotFoundException;

    void getNumberCard(String numberCard);
    
}
