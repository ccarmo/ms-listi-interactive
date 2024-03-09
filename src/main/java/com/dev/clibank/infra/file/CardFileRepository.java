package com.dev.clibank.infra.file;

import com.dev.clibank.domain.entities.Card;
import com.dev.clibank.domain.repository.CardRepository;

import java.util.List;
import java.util.Optional;

public class CardFileRepository implements CardRepository{

    private static final String CARD_FILE_NAME = "card.json";
    @Override
    public Optional<Card> getNumberCard(String numberCard) {
        List<Card> cardList = FileJsonManager.getFileListJson(CARD_FILE_NAME,Card.class);
        for (Card card : cardList) {
            if (card.getNumberCard() == numberCard) {
                return  Optional.of(card);
            }
        }
        return Optional.empty();
    }

}
