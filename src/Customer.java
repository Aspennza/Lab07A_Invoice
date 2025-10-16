import java.util.Objects;

public class Customer
{
    private String name;
    private Address custAddress;

    public Customer(String name, Address custAddress)
    {
        this.name = name;
        this.custAddress = custAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(Address custAddress) {
        this.custAddress = custAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", custAddress=" + custAddress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(custAddress, customer.custAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, custAddress);
    }

    public String getCustomerBlock()
    {
        return name.trim() + "\n" + custAddress.getFormattedAddress();
    }
}
