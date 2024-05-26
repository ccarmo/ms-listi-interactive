package com.dev.clibank.app.rest.records;

import com.dev.clibank.domain.entities.TypeAccount;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record AccountRecord(@NotBlank TypeAccount typeAccount) {
}
