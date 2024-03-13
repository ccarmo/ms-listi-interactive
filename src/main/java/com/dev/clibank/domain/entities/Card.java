package com.dev.clibank.domain.entities;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Card {

    private String idCard;
    private String numberCard;

    private String accountNumber;
    private String typeCard;
    private String securityCode;


    public Card(String accountNumber, String numberCard, String typeCard, String securityCode) {
        this.idCard = UUID.randomUUID().toString();
        this.accountNumber = accountNumber;
        this.numberCard = numberCard;
        this.typeCard = typeCard;
        this.securityCode = securityCode;
    }

    public String getAccountNumber () {
        return this.accountNumber;
    }

    public String getSecurityCode() {
        return this.securityCode;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public String getNumberCard() {
        return this.numberCard;
    }

    public String getTypeCard() {
        return this.typeCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTypeCard(String typeCard) {
        this.typeCard = typeCard;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(idCard, card.idCard) && Objects.equals(numberCard, card.numberCard) && Objects.equals(accountNumber, card.accountNumber) && Objects.equals(typeCard, card.typeCard) && Objects.equals(securityCode, card.securityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCard, numberCard, accountNumber, typeCard, securityCode);
    }

    @Override
    public String toString() {
        return "Card{" +
                "idCard='" + idCard + '\'' +
                ", numberCard='" + numberCard + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", typeCard='" + typeCard + '\'' +
                ", securityCode='" + securityCode + '\'' +
                '}';
    }
}
