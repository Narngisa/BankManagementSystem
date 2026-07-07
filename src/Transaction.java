import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private String accountId;
    private String transactionType;
    private double transactionAmount;
    private double balance;
    private String transactionId;
    private String transactionDate;


    public Transaction(String accountId, String transactionType, double transactionAmount, double balance) {
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.balance = balance;
        this.transactionId = UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();
        this.transactionDate = LocalDateTime.now().toString();
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public double getTransactionAmount() {
        return this.transactionAmount;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public void printSlip() {
        System.out.println("=================================");
        System.out.println("TRANSACTION SLIP");
        System.out.println("=================================");
        System.out.println("Transaction ID   : " + transactionId);
        System.out.println("Date & Time      : " + transactionDate);
        System.out.println("Account          : " + accountId);
        System.out.println("Type             : " + transactionType);
        System.out.println("Amount           : " + transactionAmount + " baht");
        System.out.println("Balance          : " + balance + " baht");
        System.out.println("=================================");
    }
}
