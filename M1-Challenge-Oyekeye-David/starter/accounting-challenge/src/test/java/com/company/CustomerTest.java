package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testgetBalance() {
        Customer customer = new Customer();
        AccountRecord accountRecordA = new AccountRecord();
        accountRecordA.setCharge(1000);
        customer.addCharge(accountRecordA);

        AccountRecord accountRecordB = new AccountRecord();
        accountRecordB.setCharge(2000);
        customer.addCharge(accountRecordB);

        int balance = customer.getBalance();

        Assertions.assertEquals(3000, balance);
    }

    @Test
    public void testtoString() {
        Customer customer = new Customer();
        customer.setId(1001);
        customer.setName("vibeU inc.");

        AccountRecord chargeA = new AccountRecord();
        chargeA.setCharge(1000);
        customer.addCharge(chargeA);

        AccountRecord chargeB  = new AccountRecord();
        chargeB.setCharge(200);
        customer.addCharge(chargeB);

        String expected = "CUSTOMER ID: 1001; "+
                          "CUSTOMER Name: vibeU inc.; "+
                          "CUSTOMER balance: 1200";

        Assertions.assertEquals(expected, customer.toString());
    }
}
