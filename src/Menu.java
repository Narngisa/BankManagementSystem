import java.util.Scanner;

public class Menu {

    private Bank bank;
    private Scanner scanner;

    public Menu() {
        this.bank = new Bank();
        this.scanner = new Scanner(System.in);
    }

    public void App() {

        while (true) {
            clearScreen();
            System.out.println("===== Banking System =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Create Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Show Statement");
            System.out.println("7. Show All Customer");
            System.out.println("8. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch(choice) {
                case "1":
                    addCustomer();
                    pressEnter();
                    clearScreen();
                    break;
                case "2":
                    createAccount();
                    pressEnter();
                    clearScreen();
                    break;
                case "3":
                    deposit();
                    pressEnter();
                    clearScreen();
                    break;
                case "4":
                    withdraw();
                    pressEnter();
                    clearScreen();
                    break;
                case "5":
                    transfer();
                    pressEnter();
                    clearScreen();
                    break;
                case "6":
                    showStatement();
                    pressEnter();
                    clearScreen();
                    break;
                case "7":
                    showAllCustomers();
                    pressEnter();
                    clearScreen();
                    break;
                case "8":
                    System.out.println("Goodbye!");
                    scanner.close();
                    bank.closeScanner();
                    return;
                default:
                    System.out.println("Invalid choice!");
                    pressEnter();
                    clearScreen();
            }
        }
    }

    public void addCustomer() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        bank.addCustomer(name, phone);
    }

    public void createAccount() {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        bank.createAccount(customerId, amount);
    }

    public void deposit() {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        bank.deposit(accountId, amount);
    }

    public void withdraw() {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        bank.withdraw(accountId, amount);
    }

    public void transfer() {
        System.out.print("Enter From Account ID: ");
        String from = scanner.nextLine();
        System.out.print("Enter To Account ID: ");
        String to = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        bank.transfer(from, to, amount);
    }

    public void showStatement() {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        bank.showStatement(accountId);
    }

    public void showAllCustomers() {
        bank.showAllCustomer();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void pressEnter() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
