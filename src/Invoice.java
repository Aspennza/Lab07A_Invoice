import javax.sound.sampled.Line;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Creates Invoice objects containing product and billing information to be output to a console or text box.
 * Also contains functions for acting on said objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class Invoice
{
    //This double stores the total cost of the invoice
    private double totalAmtDue;

    //This ArrayList stores LineItem objects for displaying later
    private ArrayList<LineItem> items;

    //This Customer object stores a company name and its Address
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
                "totalAmtDue=" + getTotAmtDue() +
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

    /**
     * This method calculates the total cost of the invoice.
     * @return a double containing the total cost.
     */
    public double getTotAmtDue()
    {
        for (LineItem item : items)
        {
            totalAmtDue += item.getCalcTotal();
        }
        return totalAmtDue;
    }

    /**
     * This method creates a String containing a formatted copy of all the information in the Invoice.
     * @return a String with a formatted output of all the data in the Invoice.
     */
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
