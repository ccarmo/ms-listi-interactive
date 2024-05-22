package com.dev.clibank.app.usecases;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;


public interface GetBalance {

    BigDecimal getBalance(String accountNumber);
}
