package utils;

import java.util.UUID;
import java.time.LocalDate;

public class Account {
    private String accountId;
    private String customerId;
    private double balance;
    private String openDate;

    public Account(String customerId, double initialDeposit) {
        this.accountId = UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();
        this.customerId = customerId;
        this.balance = initialDeposit;
        this.openDate = LocalDate.now().toString();
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getOpenDate() {
        return this.openDate;
    }

    public void deposit(double amount) {
         if (amount > 0) {
             this.balance += amount;
             System.out.println("Deposit " + amount + " successfully.");
        } else {
            System.out.println("Amount must be greater than zero !!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero !!");
            return false;
        } else if (amount > this.balance) {
            System.out.println("Insufficient balance! Current: " + this.balance);
            return false;
        }

        this.balance -= amount;
        System.out.println("Withdraw " + amount + " successfully!");
        return true;
    }
}
