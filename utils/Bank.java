package utils;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Bank {
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;
    private Scanner scanner = new Scanner(System.in);

    public Bank() {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addCustomer(String name, String phone) {

        Customer user = new Customer(name, phone);

        customers.add(user);
        System.out.println("Created user is successfully !!");
        System.out.println("Your ID: " + user.getCustomerId());
    }

    public void showAllCustomer() {
        if (customers.isEmpty()) {
            System.out.println("Customer not found !!");
            return;
        }

        System.out.println("===== All Customer =====");
        System.out.println("All user " + customers.size() + " Customer.");
        System.out.println("");

        for (int i = 0; i < customers.size(); i++) {
            Customer user = customers.get(i);
            System.out.println("ID: " + user.getCustomerId());
            System.out.println("Name: " + user.getName() + " | Phone: " + user.getPhone());
            System.out.println("=========================");
            System.out.println("");
        }
    }

    public void setCustomer() {
        boolean found = false;

        System.out.print("ID: ");
        String id = scanner.nextLine();

        for (int i = 0; i < customers.size(); i++) {
            Customer user = customers.get(i);
            if (user.getCustomerId().equals(id)){
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Phone: ");
                String phone = scanner.nextLine();

                user.setName(name);
                user.setPhone(phone);

                found = true;
                break;
            }

        }

        if (found) {
            System.out.println("Changed user is successfully !!");
        } else {
            System.out.println("ID not found !!");
        }
    }

    public void delCustomer() {
        Iterator<Customer> iterator = customers.iterator();
        boolean found = false;

        System.out.print("ID: ");
        String id = scanner.nextLine();

        while (iterator.hasNext()) {
            Customer user = iterator.next();
            if (user.getCustomerId().equals(id)) {
                iterator.remove();
                System.out.println("Deleted user successfully !!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("ID not found !!");
        }

    }

    public void closeScanner() {
        scanner.close();
    }

    private Account findAccount(String accountId) {

        for (int i = 0; i < accounts.size(); i++) {
            Account user = accounts.get(i);
            if (user.getAccountId().equals(accountId)) {
                return user;
            }
        }
        return null;
    }

    private Customer findCustomer(String customerId) {

        for (int i = 0; i < customers.size(); i++) {
            Customer user = customers.get(i);
            if (user.getCustomerId().equals(customerId)) {
                return user;
            }
        }
        return null;
    }


    public void createAccount(String customerId, double initialDeposit) {
        Customer customer = findCustomer(customerId);

        if (customer == null) {
            System.out.println("Account not found !!");
            return;
        }

        Account account = new Account(customerId, initialDeposit);
        Transaction transaction = new Transaction(account.getAccountId(), "OPEN", initialDeposit, account.getBalance());

        accounts.add(account);
        transactions.add(transaction);

        System.out.println("Account created successfully !!");
        System.out.println("Account ID: " + account.getAccountId());
        System.out.println("Balance: " + account.getBalance());

        transaction.printSlip();
    }

    public void deposit(String accountId, double amount) {
        Account account = findAccount(accountId);
        String transactionType = "Deposit";
        if (account == null) {
            System.out.println("Account ID not found !!");
            return;
        }
        account.deposit(amount);
        Transaction transaction = new Transaction(accountId, transactionType, amount, account.getBalance());
        transactions.add(transaction);
        transaction.printSlip();
    }

    public void withdraw(String accountId, double amount) {
        Account account = findAccount(accountId);
        String transactionType = "Withdraw";
        if (account == null) {
            System.out.println("Account ID not found !!");
            return;
        }

        boolean success = account.withdraw(amount);

        if (success) {
            Transaction transaction = new Transaction(accountId, transactionType, amount, account.getBalance());
            transactions.add(transaction);
            transaction.printSlip();
        }
    }

    public void transfer(String fromAccountId, String toAccountId, double amount) {
        Account fromAccount = findAccount(fromAccountId);
        Account toAccount = findAccount(toAccountId);
        String[] transactionType = {"Transfer Out", "Transfer In"};

        if (fromAccount == null) {
            System.out.println("Form account ID not found !!");
            return;
        } else if (toAccount == null) {
            System.out.println("To account ID not found !!");
            return;
        }

        if (fromAccountId.equals(toAccountId)) {
            System.out.println("Cannot transfer to the same account!");
            return;
        }

        boolean success = fromAccount.withdraw(amount);

        if (success) {

            toAccount.deposit(amount);

            Transaction fromTransaction = new Transaction(fromAccountId, transactionType[0], amount, fromAccount.getBalance());
            Transaction toTransaction = new Transaction(toAccountId, transactionType[1], amount, toAccount.getBalance());

            transactions.add(fromTransaction);
            transactions.add(toTransaction);

            fromTransaction.printSlip();
            toTransaction.printSlip();
        }
    }

    public void showStatement(String accountId) {
        Account account = findAccount(accountId);
        if (account == null) {
            System.out.println("Account ID not found !!");
            return;
        }

        System.out.println("STATEMENT FOR ACCOUNT: " + accountId);
        System.out.println("Current Balance: " + account.getBalance());
        System.out.println("=================================");

        boolean found = false;

        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.getAccountId().equals(accountId)) {
                transaction.printSlip();
                found = true;
            }

        }

        if (!found) {
            System.out.println("No transactions found.");
        }
    }
}
