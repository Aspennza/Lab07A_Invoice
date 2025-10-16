import javax.sound.sampled.Line;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Objects;

public class Invoice
{
    private double totalAmtDue;
    private ArrayList<LineItem> items;
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

    @Override
    public String toString() {
        return "Invoice{" +
                "totalAmtDue=" + totalAmtDue +
                ", items=" + items +
                ", cust=" + cust +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(totalAmtDue, invoice.totalAmtDue) == 0 && Objects.equals(items, invoice.items) && Objects.equals(cust, invoice.cust);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalAmtDue, items, cust);
    }

    public double getTotAmtDue()
    {
        for (LineItem item : items)
        {
            totalAmtDue += item.getCalcTotal();
        }
        return totalAmtDue;
    }

    public String getFormattedInvoice()
    {
        StringBuilder formatInvoice = new StringBuilder();
        String finalInvoice;

        formatInvoice.append("                     INVOICE                     \n");
        formatInvoice.append("=========================\n");
        formatInvoice.append(cust.getCustomerBlock());
        formatInvoice.append("\n=========================\n\n");
        formatInvoice.append("==================================================\n");
        formatInvoice.append("Item                     Qty     Price  Total\n");

        for (LineItem item : items) {
            formatInvoice.append(item.getFormattedLineItem());
            formatInvoice.append("\n");
        }

        formatInvoice.append("==================================================");
        formatInvoice.append("\n\n");
        formatInvoice.append("AMOUNT DUE: ");
        BigDecimal rounding = new BigDecimal(Double.toString(getTotAmtDue()));
        rounding = rounding.setScale(2, RoundingMode.HALF_UP);
        formatInvoice.append("$" + rounding);

        finalInvoice = formatInvoice.toString();
        return finalInvoice;
    }
}
