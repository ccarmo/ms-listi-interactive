package com.dev.clibank.infra.file;

import com.dev.clibank.domain.entities.Card;
import com.dev.clibank.domain.repository.CardRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CardFileRepository implements CardRepository{

    @Override
    public void get(Card card) throws FileNotFoundException {


    }

    @Override
    public void getNumberCard(String numberCard) {

    }

}
