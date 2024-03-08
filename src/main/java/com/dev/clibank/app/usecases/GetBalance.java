package com.dev.clibank.app.usecases;

import java.math.BigDecimal;

public interface GetBalance {

    BigDecimal getBalance(String accountNumber);
}
