package com.dev.clibank.app.services;

import com.dev.clibank.app.usecases.SendPayment;
import com.dev.clibank.domain.entities.Payment;
import com.dev.clibank.domain.repository.StatementRepository;

public class PaymentService {

    private SendPayment sendPaymentService;

    public PaymentService(SendPayment sendPaymentService) {
        this.sendPaymentService = sendPaymentService;
    }

    public void sendPayment(Payment payment) {
        this.sendPaymentService.sendPayment(payment);

    }
}
