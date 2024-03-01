package com.dev.clibank.vo;


import com.dev.clibank.domain.vo.Address;
import org.junit.Assert;
import org.junit.Test;


public class AddressTest {

    @Test
    public void addressObjectIsNotNull() {
        Address address = new Address("Rua Gomes de Carvalho", "Brasil", "999");
        Assert.assertNotNull(address);
    }
}
