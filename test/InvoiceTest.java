import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

/**
 * Tests the basic functionality of the methods in the Invoice.java class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class InvoiceTest {

    //An Address object for incorporating in the Customer objects
    Address address1;

    //A Customer object for incorporating into the Invoices
    Customer cust1;

    //A Customer object for incorporating into the Invoices
    Customer cust2;

    //A Product object for incorporating into the LineItem ArrayLists
    Product product1;

    //A Product object for incorporating into the LineItem ArrayLists
    Product product2;

    //A LineItem ArrayList for incorporating into the Invoices
    ArrayList<LineItem> lineItems1;

    //A LineItem ArrayList for incorporating into the Invoices
    ArrayList<LineItem> lineItems2;

    //An Invoice object for testing the methods
    Invoice invoice1;

    //An Invoice object for testing the methods
    Invoice invoice2;

    //An Invoice object for testing the methods
    Invoice invoice3;

    @BeforeEach
    void setUp() {
        address1 = new Address("1111 Street St.", "Suite 101", "Cincinnati", "OH", "45200");
        cust1 = new Customer("Company1", address1);
        cust2 = new Customer("Company2", address1);
        product1 = new Product("Piggy Bank", 15.00);
        product2 = new Product("Grilled Cheese", 7.00);
        lineItems1 = new ArrayList<>();
        lineItems1.add(new LineItem(3, product1));
        lineItems1.add(new LineItem(4, product2));
        lineItems2 = new ArrayList<>();
        lineItems2.add(new LineItem(2, product1));
        lineItems2.add(new LineItem(7, product2));
        invoice1 = new Invoice(lineItems1, cust1);
        invoice2 = new Invoice(lineItems2, cust2);
        invoice3 = new Invoice(lineItems1, cust1);
    }

    @Test
    void testInvoiceConstructor() {
        Invoice invoice4 = new Invoice(lineItems1, cust1);
        assertEquals(lineItems1, invoice4.getItems());
        assertEquals(cust1, invoice4.getCust());
    }

    @Test
    void setItems() {
        invoice1.setItems(lineItems2);
        assertEquals(lineItems2, invoice1.getItems());
    }

    @Test
    void setCust() {
        invoice1.setCust(cust2);
        assertEquals(cust2, invoice1.getCust());
    }

    @Test
    void testToString() {
        assertEquals("Invoice{totalAmtDue=73.0, items=[LineItem{quantity=3.0, calculatedTotal=45.0, userProduct=Product{name='Piggy Bank', unitPrice=15.0}}, LineItem{quantity=4.0, calculatedTotal=28.0, userProduct=Product{name='Grilled Cheese', unitPrice=7.0}}], cust=Customer{name='Company1', custAddress=Address{street='1111 Street St.', apt='Suite 101', city='Cincinnati', state='OH', zip='45200'}}}", invoice1.toString());
    }

    @Test
    void testEquals() {
        assertTrue(invoice1.equals(invoice3));
        assertFalse(invoice1.equals(invoice2));
    }

    @Test
    void testHashCode() {
        assertEquals(1736445902, invoice1.hashCode());
    }

    @Test
    void getTotAmtDue() {
        assertEquals(73.0, invoice1.getTotAmtDue());
    }

    @Test
    void getFormattedInvoice() {
        assertEquals("                     INVOICE                     \n=========================\nCompany1\n1111 Street St. Suite 101\nCincinnati, OH 45200\n=========================\n\n==================================================\nItem                     Qty     Price  Total\nPiggy Bank               3.00    15.00  45.00     \nGrilled Cheese           4.00    7.00   28.00     \n==================================================\n\nAMOUNT DUE: $73.00", invoice1.getFormattedInvoice());
    }
}