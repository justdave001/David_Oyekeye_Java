package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCharge(AccountRecord charge){
        charges.add(charge);
    }
    public int getBalance() {
        //update this
        int balance = 0;
        for (AccountRecord record : getCharges()){
            balance += record.getCharge();
        }
        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //update this
        String ID           = String.valueOf(id);
        String balance      = String.valueOf(getBalance());
        String customerName = getName();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CUSTOMER ID: "      + ID + "; ");
        stringBuilder.append("CUSTOMER Name: "    + customerName + "; ");
        stringBuilder.append("CUSTOMER balance: " + balance);

        return stringBuilder.toString();
    }
}
