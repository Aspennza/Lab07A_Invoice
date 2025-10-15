import java.util.Objects;

public class Product
{
    private String name;
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

    //May not need toString?
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }

    //May not need equals?
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(unitPrice, product.unitPrice) == 0 && Objects.equals(name, product.name);
    }

    //May not need hashCode?
    @Override
    public int hashCode() {
        return Objects.hash(name, unitPrice);
    }
}
