package utils;

import java.util.UUID;

public class Customer {
    private String customerId;
    private String name;
    private String phone;

    public Customer(String name, String phone) {

        String randomID = UUID.randomUUID().toString().replace("-", "");

        this.customerId = randomID;
        this.name = name;
        this.phone = phone;
    }

    // Get Data

    public String getCustomerId() {
        return this.customerId;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    // Edit Data

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
