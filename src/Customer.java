import java.util.UUID;
import java.util.Scanner;
import java.util.Iterator;

import java.util.ArrayList;

public class Customer {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    private String customerId;
    private String name;
    private String phone;

    public Customer(String name, String phone) {

        String randomID = UUID.randomUUID().toString().replace("-", "");

        this.customerId = randomID;
        this.name = name;
        this.phone = phone;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static void addCustomer() {

        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Phone: ");
        String phone = input.nextLine();

        Customer user = new Customer(name, phone);

        customers.add(user);
        System.out.println("Created user is successfully !!");
        System.out.println("Your ID: " + user.getCustomerId());
    }

    public static void showAllCustomer() {
        if (customers.isEmpty()) {
            System.out.println("User data not found !!");
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
        }
    }

    public static void setCustomer() {
        boolean found = false;

        System.out.print("ID: ");
        String id = input.nextLine();

        for (int i = 0; i < customers.size(); i++) {
            Customer user = customers.get(i);
            if (user.getCustomerId().equals(id)){
                System.out.print("Name: ");
                String name = input.nextLine();
                System.out.print("Phone: ");
                String phone = input.nextLine();

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

    public static void delCustomer() {
        Iterator<Customer> iterator = customers.iterator();
        boolean found = false;

        System.out.print("ID: ");
        String id = input.nextLine();

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

    public static void closeScanner() {
        input.close();
    }

}
