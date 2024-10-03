package Bank_System_Methods;


public class Customer extends Person {

    public Customer(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Name='" + getName() + "' Address='" + getAddress() + "' Phone Number='" + getPhoneNumber() +
                '}';
    }
}