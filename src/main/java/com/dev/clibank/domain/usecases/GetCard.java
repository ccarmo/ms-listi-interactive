package com.dev.clibank.domain.usecases;

import com.dev.clibank.domain.entities.Card;
import com.dev.clibank.domain.entities.User;
import com.dev.clibank.domain.repository.CardRepository;
import com.dev.clibank.infra.file.CardFileRepository;


public class GetCard {

    private CardRepository cardRepository = new CardFileRepository();

    public GetCard(Card card) {
        getCard(card);
    }

    public void getCard(Card card) {
        cardRepository.getNumberCard(card.getNumberCard());
    }
}
