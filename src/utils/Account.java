package utils;

import java.util.UUID;

public class Account {
    private String accountId;
    private String customer;
    private double balance = 0.0;

    public Account(String customer, double balance) {

        String accountId = UUID.randomUUID().toString().replace("-", "");

        this.accountId = accountId;
        this.customer = customer;
        this.balance = balance;
    }

    public String getCustomer() {
        return this.customer;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public double getBalance() {
        return this.balance;
    }
}
