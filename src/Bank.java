import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;

    public Bank() {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
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
            System.out.println("Customer not found !!");
            return;
        }

        Account account = new Account(customerId, initialDeposit);

        accounts.add(account);

        System.out.println("Account created successfully !!");
        System.out.println("Account ID: " + account.getAccountId());
        System.out.println("Balance: " + account.getBalance());
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
}
