import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the basic functionality of the methods in the Address.java class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class AddressTest {

    //An Address object for testing the methods
    Address address1;

    //An Address object for testing the methods
    Address address2;

    //An Address object for testing the methods
    Address address3;

    //An Address object for testing the methods
    Address address4;

    @BeforeEach
    void setUp() {
        address1 = new Address("1111 Street St.", "Suite 101", "Cincinnati", "OH", "45200");
        address2 = new Address("1111 Street St.", "Suite 101", "Cincinnati", "OH", "45200");
        address3 = new Address("1111 Street St.", "Cincinnati", "OH", "45200");
        address4 = new Address("1111 Street St.", "Suite 102", "Cincinnati", "OH", "45200");
    }

    @Test
    void testAddressConstructor1() {
        Address address5 = new Address("1111 Street St.", "Suite 101", "Cincinnati", "OH", "45200");
        assertEquals("1111 Street St.", address5.getStreet());
        assertEquals("Suite 101", address5.getApt());
        assertEquals("Cincinnati", address5.getCity());
        assertEquals("OH", address5.getState());
        assertEquals("45200",address5.getZip());
    }

    @Test
    void testAddressConstructor2() {
        Address address5 = new Address("1111 Street St.", "Cincinnati", "OH", "45200");
        assertEquals("1111 Street St.", address5.getStreet());
        assertEquals("Cincinnati", address5.getCity());
        assertEquals("OH", address5.getState());
        assertEquals("45200",address5.getZip());
    }

    @Test
    void setStreet() {
        address1.setStreet("1112 Street St.");
        assertEquals("1112 Street St.", address1.getStreet());
    }

    @Test
    void setApt() {
        address1.setApt("Suite 105");
        assertEquals("Suite 105", address1.getApt());
    }

    @Test
    void setCity() {
        address1.setCity("Columbus");
        assertEquals("Columbus", address1.getCity());
    }

    @Test
    void setState() {
        address1.setState("NY");
        assertEquals("NY", address1.getState());
    }

    @Test
    void setZip() {
        address1.setZip("45210");
        assertEquals("45210", address1.getZip());
    }

    @Test
    void testToString() {
        assertEquals("Address{street='1111 Street St.', apt='Suite 101', city='Cincinnati', state='OH', zip='45200'}", address1.toString());
        assertEquals("Address{street='1111 Street St.', city='Cincinnati', state='OH', zip='45200'}", address3.toString());
    }

    @Test
    void testEquals() {
        assertTrue(address1.equals(address2));
        assertFalse(address1.equals(address3));
        assertFalse(address1.equals(address4));
    }

    @Test
    void testHashCode() {
        assertEquals(637666629, address1.hashCode());
        assertEquals(1806273201, address3.hashCode());
    }

    @Test
    void getFormattedAddress()
    {
        assertEquals("1111 Street St. Suite 101\nCincinnati, OH 45200", address1.getFormattedAddress());
        assertEquals("1111 Street St.\nCincinnati, OH 45200", address3.getFormattedAddress());
    }
}