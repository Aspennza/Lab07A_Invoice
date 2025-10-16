import java.util.Objects;

public class LineItem
{
    private double quantity;
    private double calculatedTotal;
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

    //May not need toString??
    @Override
    public String toString() {
        return "LineItem{" +
                "quantity=" + quantity +
                ", calculatedTotal=" + calculatedTotal +
                ", userProduct=" + userProduct +
                '}';
    }

    //May not need?
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return Double.compare(quantity, lineItem.quantity) == 0 && Double.compare(calculatedTotal, lineItem.calculatedTotal) == 0 && Objects.equals(userProduct, lineItem.userProduct);
    }

    //May not need?
    @Override
    public int hashCode() {
        return Objects.hash(quantity, calculatedTotal, userProduct);
    }

    public double getCalcTotal()
    {
        calculatedTotal = quantity * userProduct.getUnitPrice();
        return calculatedTotal;
    }

    public String getFormattedLineItem()
    {
        return String.format("%-25s", userProduct.getName().trim()) + String.format("%-5s", quantity) + String.format("%-10.2f", userProduct.getUnitPrice()) + String.format("%-10.2f", calculatedTotal);
    }
}
