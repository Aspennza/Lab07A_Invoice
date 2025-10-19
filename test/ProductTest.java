import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the basic functionality of the methods in the Product.java class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class ProductTest {

    //A Product object for testing the methods
    Product prod1;

    //A Product object for testing the methods
    Product prod2;

    //A Product object for testing the methods
    Product prod3;

    @BeforeEach
    void setUp() {
        prod1 = new Product("Piggy Bank", 15.00);
        prod2 = new Product("Grilled Cheese", 7.00);
        prod3 = new Product("Piggy Bank", 15.00);
    }

    @Test
    void testProductConstructor() {
        Product prod3 = new Product("Lettuce", 3.00);
        assertEquals("Lettuce", prod3.getName());
        assertEquals(3.00, prod3.getUnitPrice());
    }

    @Test
    void setName() {
        prod1.setName("Xylophone");
        assertEquals("Xylophone", prod1.getName());
    }

    @Test
    void setUnitPrice() {
        prod1.setUnitPrice(20.00);
        assertEquals(20.00, prod1.getUnitPrice());
    }

    @Test
    void testToString() {
        assertEquals("Product{name='Piggy Bank', unitPrice=15.0}", prod1.toString());
    }

    @Test
    void testEquals() {
        assertFalse(prod1.equals(prod2));
        assertTrue(prod1.equals(prod3));
    }

    @Test
    void testHashCode() {
        assertEquals(-1474042971, prod1.hashCode());
    }
}