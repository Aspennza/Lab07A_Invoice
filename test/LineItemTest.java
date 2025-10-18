import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineItemTest {

    Product prod1;
    Product prod2;
    LineItem item1;
    LineItem item2;
    LineItem item3;

    @BeforeEach
    void setUp() {
        prod1 = new Product("Piggy Bank", 15.00);
        prod2 = new Product("Grilled Cheese", 7.00);
        item1 = new LineItem(3, prod1);
        item2 = new LineItem(2, prod2);
        item3 = new LineItem(3, prod1);
    }

    @Test
    void testLineItemConstructor() {
        LineItem item4 = new LineItem(5, prod1);
        assertEquals(5, item4.getQuantity());
        assertEquals(prod1, item4.getUserProduct());
    }

    @Test
    void setQuantity() {
        item1.setQuantity(6);
        assertEquals(6, item1.getQuantity());
    }

    @Test
    void testToString() {
        assertEquals("LineItem{quantity=3.0, calculatedTotal=45.0, userProduct=Product{name='Piggy Bank', unitPrice=15.0}}", item1.toString());
    }

    @Test
    void testEquals() {
        assertFalse(item1.equals(item2));
        assertTrue(item1.equals(item3));
    }

    @Test
    void testHashCode() {
        assertEquals(103569412, item1.hashCode());
    }

    @Test
    void getCalcTotal() {
        assertEquals(45.00, item1.getCalcTotal());
    }

    @Test
    void getFormattedLineItem() {
        assertEquals("Piggy Bank               3.00    15.00  45.00     ", item1.getFormattedLineItem());
    }
}