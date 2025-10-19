import java.util.Objects;

/**
 * Allows the creation of LineItem objects storing a product, its quantity, and the total cost.
 * Also includes functions for acting on said objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class LineItem
{
    //This double stores the quantity of the selected Product
    private double quantity;

    //This double stores the total cost of the number of Products
    private double calculatedTotal;

    //This Product object stores the product data, like name and unit price
    private Product userProduct;

    public LineItem(double quantity, Product userProduct)
    {
        this.quantity = quantity;
        this.userProduct = userProduct;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCalculatedTotal() {
        return calculatedTotal;
    }

    public Product getUserProduct() {
        return userProduct;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "quantity=" + quantity +
                ", calculatedTotal=" + getCalcTotal() +
                ", userProduct=" + userProduct +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return Double.compare(quantity, lineItem.quantity) == 0 && Double.compare(calculatedTotal, lineItem.calculatedTotal) == 0 && Objects.equals(userProduct, lineItem.userProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, calculatedTotal, userProduct);
    }

    /**
     * This method calculates the total cost of each LineItem based on the product and its quantity.
     * @return a double representing the total cost.
     */
    public double getCalcTotal()
    {
        calculatedTotal = quantity * userProduct.getUnitPrice();
        return calculatedTotal;
    }

    /**
     * This method creates a neatly-formatted String containing the information in the LineItem.
     * @return a String containing the data in the LineItem.
     */
    public String getFormattedLineItem()
    {
        return String.format("%-25s", userProduct.getName().trim()) + String.format("%-8.2f", quantity) + String.format("%-7.2f", userProduct.getUnitPrice()) + String.format("%-10.2f", getCalcTotal());
    }
}
