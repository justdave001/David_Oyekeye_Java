package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        Map<Integer, Customer> customerMap = new HashMap<>();


        for (String[] customer : customerData) {
            int customerID = Integer.parseInt(customer[0]);

            if (!customerMap.containsKey(customerID)){
                Customer newCustomer = new Customer();
                newCustomer.setId(customerID);
                newCustomer.setName(customer[1]);
                customerMap.put(customerID, newCustomer);
            }

            Customer existingCustomer = customerMap.get(customerID);

            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(Integer.parseInt(customer[2]));
            accountRecord.setChargeDate(customer[3]);

            existingCustomer.addCharge(accountRecord);
        }

        List<Customer> customerObjects   = new ArrayList<>(customerMap.values());
        StringBuilder  positiveAccts     = new StringBuilder();
        StringBuilder  negativeAccts     = new StringBuilder();

        for (Customer customer : customerObjects){
            if (customer.getBalance() < 0){
                negativeAccts.append(customer).append("\n");
            } else {
                positiveAccts.append(customer).append("\n");
            }

        }
        //Update this
        System.out.println("Positive accounts:" + "\n" + positiveAccts);
        System.out.println("Negative accounts:" + "\n" + negativeAccts);
    }
}
