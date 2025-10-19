import java.util.Objects;

/**
 * Allows the creation of Customer objects representing companies, including names and
 * Address objects. Also includes functions for acting on said objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class Customer
{
    //This String stores the name of the company
    private String name;

    //This Address stores the company's address
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

    /**
     * This method outputs the Customer's name and Address in a readable format.
     * @return a String containing the Customer's name and Address.
     */
    public String getCustomerBlock()
    {
        return name.trim() + "\n" + custAddress.getFormattedAddress();
    }
}
