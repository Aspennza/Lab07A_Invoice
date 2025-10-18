import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer cust1;
    Customer cust2;
    Customer cust3;
    Address address1;
    Address address2;

    @BeforeEach
    void setUp() {
        address1 = new Address("1111 Street St.", "Suite 101", "Cincinnati", "OH", "45200");
        address2 = new Address("1111 Street St.", "Cincinnati", "OH", "45200");
        cust1 = new Customer("Company1", address1);
        cust2 = new Customer("Company1", address2);
        cust3 = new Customer("Company1", address1);
    }

    @Test
    void testCustomerConstructor() {
        Customer cust3 = new Customer("Company3", address2);
        assertEquals("Company3", cust3.getName());
        assertEquals(address2, cust3.getCustAddress());
    }

    @Test
    void setName() {
        cust1.setName("Company2");
        assertEquals("Company2", cust1.getName());
    }

    @Test
    void setCustAddress() {
        cust1.setCustAddress(address2);
        assertEquals(address2, cust1.getCustAddress());
    }

    @Test
    void testToString() {
        assertEquals("Customer{name='Company1', custAddress=Address{street='1111 Street St.', apt='Suite 101', city='Cincinnati', state='OH', zip='45200'}}", cust1.toString());
    }

    @Test
    void testEquals() {
        assertFalse(cust1.equals(cust2));
        assertTrue(cust1.equals(cust3));
    }

    @Test
    void testHashCode() {
        assertEquals(1228816402, cust1.hashCode());
    }

    @Test
    void getCustomerBlock() {
        assertEquals("Company1\n1111 Street St. Suite 101\nCincinnati, OH 45200", cust1.getCustomerBlock());
    }
}