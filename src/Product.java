import java.util.Objects;

/**
 * Allows the creation of Product objects storing a product's name and price per unit.
 * Also includes functions for acting on said objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class Product
{
    //This String stores the name of the product
    private String name;

    //This double stores the price per unit of the product
    private double unitPrice;

    public Product(String name, double unitPrice)
    {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(unitPrice, product.unitPrice) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unitPrice);
    }
}
