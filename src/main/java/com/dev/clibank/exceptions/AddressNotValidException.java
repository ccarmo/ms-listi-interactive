package com.dev.clibank.exceptions;

public class AddressNotValidException extends RuntimeException {

    public AddressNotValidException(String message) {
        super(message);
    }

}
