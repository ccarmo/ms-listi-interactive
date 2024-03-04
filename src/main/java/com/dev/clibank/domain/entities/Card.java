package com.dev.clibank.domain.entities;

import java.util.Date;

public class Card {
    private String numberCard;

    private Account account;
    private String typeCard;
    private Date dateValidated;

    private String securityCode;


    public Card(Account account, String numberCard, String typeCard, String securityCode) {
        this.account = account;
        this.numberCard = numberCard;
        this.typeCard = typeCard;
        this.securityCode = securityCode;
    }
}
