package com.dev.clibank.domain.entities;

import java.util.Date;
import java.util.UUID;

public class Card {
    private String numberCard;

    private Account account;
    private String typeCard;

    private String id;

    private String securityCode;


    public Card(Account account, String numberCard, String typeCard, String securityCode) {
        this.id = UUID.randomUUID().toString();
        this.account = account;
        this.numberCard = numberCard;
        this.typeCard = typeCard;
        this.securityCode = securityCode;
    }

    public String accountUserName() {
        return this.account.getUserName();
    }

    public String getSecurityCode() {
        return this.securityCode = securityCode;
    }

    public String getId() {
        return this.id;
    }

    public String getNumberCard() {
        return this.numberCard;
    }

    public String getTypeCard() {
        return this.typeCard;
    }

    public Account getAccount() {
        return this.account;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Card card = (Card) obj;
        if (!this.numberCard.equals(card.getNumberCard()) ||
                !this.id.equals(card.getId()) ||
                !this.typeCard.equals(card.getTypeCard()) ||
                !this.account.equals(card.getAccount())) {
            return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
