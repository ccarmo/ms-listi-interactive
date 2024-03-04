package com.dev.clibank.vo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.dev.clibank.domain.vo.Address;


public class AddressTest {

    @Test
    public void addressObjectIsNotNull() {
        Address address = new Address("Rua Gomes de Carvalho", "Brasil", "999");
        Assertions.assertNotNull(address);
    }
}
