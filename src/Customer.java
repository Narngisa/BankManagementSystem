import java.util.UUID;

public class Customer {

    private String customerId;
    private String name;
    private String phone;

    public Customer(String name, String phone) {

        this.customerId = UUID.randomUUID().toString().replace("-", "").substring(0, 20);
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

}
