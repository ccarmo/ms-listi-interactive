package com.dev.clibank.app.usecases;

import com.dev.clibank.domain.entities.Payment;

public interface SendPayment {

    void sendPayment(Payment payment);
}
