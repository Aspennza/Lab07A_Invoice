import java.util.ArrayList;

public class Invoice
{
    private double totalAmtDue;
    private ArrayList<LineItem> items = new ArrayList<>();
    private Customer cust;

    public Invoice(ArrayList<LineItem> items, Customer cust)
    {
        this.items = items;
        this.cust = cust;
    }

    public double getTotalAmtDue() {
        return totalAmtDue;
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<LineItem> items) {
        this.items = items;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }


}
