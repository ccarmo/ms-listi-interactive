package com.dev.clibank.app.rest.records;

import java.math.BigDecimal;

public record AccountRecord(String accountNumber, BigDecimal balance) {
}
