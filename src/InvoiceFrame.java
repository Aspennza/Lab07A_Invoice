import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

//need to write javadoc

/**
 * Creates an extension of the JFrame class called InvoiceFrame. Allows users
 * to input product and billing information and outputs a formatted invoice.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class InvoiceFrame extends javax.swing.JFrame
{
    //A JPanel containing all the other JPanels in the program
    JPanel mainPnl;

    //A JPanel containing a JLabel title for the program
    JPanel titlePnl;

    //A JPanel containing input fields for users to input product data
    JPanel productInfoPnl;

    //A JPanel containing input fields for users to input billing information
    JPanel billingInfoPnl;

    //A JPanel containing buttons for submitting data, clearing the fields, and closing the program
    JPanel controlPnl;

    //A JPanel containing a text box for outputting the finished invoice
    JPanel outputPnl;

    //A JLabel containing the title of the application
    JLabel titleLbl;

    //A large, serif font for the application's title
    Font titlePnlFont;

    //A smaller, serif font for the application's subheaders
    Font subtitleFont = new Font("Serif", Font.BOLD, 25);

    //A small, monospaced font for the output field
    Font monospace = new Font("Monospaced", Font.PLAIN, 12);

    //A JLabel that acts as a title for the product information panel
    JLabel prodInfoLbl;

    //A JLabel for the product name field
    JLabel prodNameLbl;

    //A JLabel for the unit price field
    JLabel unitPriceLbl;

    //A JLabel for the quantity field
    JLabel quantityLbl;

    //A JTextField for the product name
    JTextField prodNameTF;

    //A JTextField for the unit price
    JTextField unitPriceTF;

    //A JTextField for the quantity
    JTextField quantityTF;

    //A JButton for creating products to add to LineItems in the items ArrayList
    JButton addProductBtn;

    //A JLabel for the billing info panel's title
    JLabel billingInfoLbl;

    //A JLabel for the company name field
    JLabel companyLbl;

    //A JLabel for the street address field
    JLabel streetLbl;

    //A JLabel for the address line 2 field
    JLabel aptLbl;

    //A JLabel for the city field
    JLabel cityLbl;

    //A JLabel for the state field
    JLabel stateLbl;

    //A JLabel for the zip code field
    JLabel zipLbl;

    //A JTextField for the company's name
    JTextField companyTF;

    //A JTextField for the company's street address
    JTextField streetTF;

    //A JTextField for the company's apartment number
    JTextField aptTF;

    //A JTextField for the company's city
    JTextField cityTF;

    //A JTextField for the company's state
    JTextField stateTF;

    //A JTextField for the company's zip code
    JTextField zipTF;

    //A JButton for submitting and processing the input
    JButton submitBtn;

    //A JButton for clearing all the input fields
    JButton clearBtn;

    //A JButton for quitting the program
    JButton quitBtn;

    //A JLabel for the finished Invoice panel
    JLabel compInvoiceLbl;

    //A JTextArea for outputting the finished Invoice
    JTextArea compInvoiceTA;

    //A JScrollPane for the JTextArea above
    JScrollPane scroller;

    //Some GridBagConstraints for each of the panels inside mainPnl
    GridBagConstraints gbc = new GridBagConstraints();

    //Some GridBagConstraints for the title of each panel
    GridBagConstraints titleGBC = new GridBagConstraints();

    //Some GridBagConstraints for the first label in each panel
    GridBagConstraints label1GBC = new GridBagConstraints();

    //Some GridBagConstraints for the first text field in each panel
    GridBagConstraints TF1GBC = new GridBagConstraints();

    //Some GridBagConstraints for the second label in each panel
    GridBagConstraints label2GBC = new GridBagConstraints();

    //Some GridBagConstraints for the second text field in each panel
    GridBagConstraints TF2GBC = new GridBagConstraints();

    //Some GridBagConstraints for the third label in each panel
    GridBagConstraints label3GBC = new GridBagConstraints();

    //Some GridBagConstraints for the third text field in each panel
    GridBagConstraints TF3GBC = new GridBagConstraints();

    //Some GridBagConstraints for the fourth label in each panel
    GridBagConstraints label4GBC = new GridBagConstraints();

    //Some GridBagConstraints for the fourth text field in each panel
    GridBagConstraints TF4GBC = new GridBagConstraints();

    //Some GridBagConstraints for the fifth label in each panel
    GridBagConstraints label5GBC = new GridBagConstraints();

    //Some GridBagConstraints for the fifth text field in each panel
    GridBagConstraints TF5GBC = new GridBagConstraints();

    //Some GridBagConstraints for the sixth label in each panel
    GridBagConstraints label6GBC = new GridBagConstraints();

    //Some GridBagConstraints for the sixth text field in each panel
    GridBagConstraints TF6GBC = new GridBagConstraints();

    //Some GridBagConstraints for the add product button
    GridBagConstraints BtnGBC = new GridBagConstraints();

    //An ArrayList of type LineItem for storing a list of LineItems that will be input into the finished invoice
    ArrayList<LineItem> lineItems = new ArrayList<>();

    //A boolean for checking whether a complete invoice has been generated
    boolean submitted = false;

    //A boolean for checking if any products have previously been input already
    boolean firstProduct = true;

    /**
     * This constructor determines the basic settings for InvoiceFrame and calls
     * all the methods that establish the individual panels in the frame.
     */
    public InvoiceFrame()
    {
        super("Invoice Creator");

        //This Toolkit is used to find the screen size of the computer running the GUI
        Toolkit kit = Toolkit.getDefaultToolkit();

        //This Dimension stores the screen size
        Dimension screenSize = kit.getScreenSize();

        //This int stores the height of the screen
        int screenHeight = screenSize.height;

        //This int stores the width of the screen
        int screenWidth = screenSize.width;

        mainPnl = new JPanel();
        mainPnl.setBackground(new Color(255, 255, 255));
        mainPnl.setLayout(new GridBagLayout());
        add(mainPnl);

        createTitlePnl();

        createProductInfoPnl();

        createBillingInfoPnl();

        createControlPnl();

        createOutputPnl();

        setSize(screenWidth * 3/4, screenHeight * 3/4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Invoice Creator");
        setVisible(true);
    }

    /**
     * This method establishes the titlePnl, its GridBagConstraints, and the JLabel inside of it.
     */
    private void createTitlePnl()
    {
        titlePnl = new JPanel();
        titlePnl.setBackground(new Color(186, 205, 255, 255));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;

        titlePnl.setBorder(new CompoundBorder((new EtchedBorder()), new EmptyBorder(10, 10, 10, 10)));

        titleLbl = new JLabel("Invoice Creator");
        titlePnlFont = new Font("Serif", Font.BOLD, 48);
        titleLbl.setFont(titlePnlFont);

        titlePnl.add(titleLbl);
        mainPnl.add(titlePnl, gbc);
    }

    /**
     * This method establishes the productInfoPnl, its GridBagConstraints, and the labels,
     * fields, and button that go inside it. Also establishes the logic for the button.
     */
    private void createProductInfoPnl()
    {
        productInfoPnl = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;

        productInfoPnl.setBorder(new CompoundBorder((new EtchedBorder()), new EmptyBorder(10, 10, 10, 10)));
        productInfoPnl.setLayout(new GridBagLayout());

        prodInfoLbl = new JLabel("Product Information");

        prodInfoLbl.setFont(subtitleFont);
        titleGBC.gridx = 0;
        titleGBC.gridy = 0;
        titleGBC.gridwidth = 2;
        titleGBC.gridheight = 1;
        titleGBC.fill = GridBagConstraints.BOTH;
        titleGBC.insets = new Insets(10, 10, 10, 10);
        productInfoPnl.add(prodInfoLbl, titleGBC);

        prodNameLbl = new JLabel("Product Name:");
        label1GBC.gridx = 0;
        label1GBC.gridy = 1;
        label1GBC.gridwidth = 1;
        label1GBC.gridheight = 1;
        label1GBC.fill = GridBagConstraints.BOTH;
        prodNameTF = new JTextField(15);
        TF1GBC.gridx = 1;
        TF1GBC.gridy = 1;
        TF1GBC.gridwidth = 1;
        TF1GBC.gridheight = 1;
        TF1GBC.fill = GridBagConstraints.BOTH;
        TF1GBC.insets = new Insets(10, 10, 10, 10);

        productInfoPnl.add(prodNameLbl, label1GBC);
        productInfoPnl.add(prodNameTF, TF1GBC);

        unitPriceLbl = new JLabel("Product Unit Price:");
        label2GBC.gridx = 0;
        label2GBC.gridy = 2;
        label2GBC.gridwidth = 1;
        label2GBC.gridheight = 1;
        label2GBC.fill = GridBagConstraints.BOTH;
        unitPriceTF = new JTextField(15);
        TF2GBC.gridx = 1;
        TF2GBC.gridy = 2;
        TF2GBC.gridwidth = 1;
        TF2GBC.gridheight = 1;
        TF2GBC.fill = GridBagConstraints.BOTH;
        TF2GBC.insets = new Insets(10, 10, 10, 10);

        productInfoPnl.add(unitPriceLbl, label2GBC);
        productInfoPnl.add(unitPriceTF, TF2GBC);

        quantityLbl = new JLabel("Quantity:");
        label3GBC.gridx = 0;
        label3GBC.gridy = 3;
        label3GBC.gridwidth = 1;
        label3GBC.gridheight = 1;
        label3GBC.fill = GridBagConstraints.BOTH;
        quantityTF = new JTextField(15);
        TF3GBC.gridx = 1;
        TF3GBC.gridy = 3;
        TF3GBC.gridwidth = 1;
        TF3GBC.gridheight = 1;
        TF3GBC.fill = GridBagConstraints.BOTH;
        TF3GBC.insets = new Insets(10, 10, 10, 10);

        productInfoPnl.add(quantityLbl, label3GBC);
        productInfoPnl.add(quantityTF, TF3GBC);

        addProductBtn = new JButton("Add Product");
        addProductBtn.setBackground(new Color(42, 74, 147, 255));
        addProductBtn.setForeground(new Color(255, 255, 255));
        BtnGBC.gridx = 0;
        BtnGBC.gridy = 4;
        BtnGBC.gridwidth = 2;
        BtnGBC.gridheight = 1;
        BtnGBC.insets = new Insets(10, 10, 10, 10);

        addProductBtn.addActionListener((ActionEvent ae) ->
        {
            //This algorithm determines whether the form has been submitted yet; if so, prompts the user to clear the program before creating a new invoice
            if(!submitted) {
                //This algorithm determines if any of the input fields are empty
                if (prodNameTF.getText().trim().isEmpty() || unitPriceTF.getText().trim().isEmpty() || quantityTF.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "To add a product, the Product Name, Product Unit Price, and Quantity fields must all be filled.");
                } else {
                    //This double stores the user's input unit price
                    double unitPrice;

                    //This double stores the user's input quantity
                    double quantity;

                    //This algorithm parses the user's input into doubles and creates LineItems based on it
                    try {
                        unitPrice = Double.parseDouble(unitPriceTF.getText().trim());
                        quantity = Double.parseDouble(quantityTF.getText().trim());

                        //This Product is created based on the user's input
                        Product prod = new Product(prodNameTF.getText().trim(), unitPrice);

                        lineItems.add(new LineItem(quantity, prod));

                        prodNameTF.setText("");
                        unitPriceTF.setText("");
                        quantityTF.setText("");

                        //This algorithm determines whether to show this pop-up message based on if the user has entered products before or not
                        if(firstProduct)
                        {
                            JOptionPane.showMessageDialog(null, "Product added. You can continue adding new products to the invoice if desired. Otherwise, move to the Billing Information fields.");
                        }

                        firstProduct = false;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Values in the Product Unit Price and Quantity fields must be written using digits (1, 2.25, 3, etc.) only.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "To create another invoice, please click the Clear Form button, then add new data.");
            }
        });

        productInfoPnl.add(addProductBtn, BtnGBC);

        mainPnl.add(productInfoPnl, gbc);
    }

    /**
     * This method establishes the billingInfoPnl, its GridBagConstraints, and its labels and fields.
     */
    private void createBillingInfoPnl()
    {
        billingInfoPnl = new JPanel();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;

        billingInfoPnl.setBorder(new CompoundBorder((new EtchedBorder()), new EmptyBorder(10, 10, 10, 10)));
        billingInfoPnl.setLayout(new GridBagLayout());

        billingInfoLbl = new JLabel("Billing Information");
        billingInfoLbl.setFont(subtitleFont);
        titleGBC.gridx = 0;
        titleGBC.gridy = 0;
        titleGBC.gridwidth = 2;
        titleGBC.gridheight = 1;
        titleGBC.fill = GridBagConstraints.BOTH;
        titleGBC.insets = new Insets(10, 10, 10, 10);

        billingInfoPnl.add(billingInfoLbl, titleGBC);

        companyLbl = new JLabel("Company to be billed:");
        label1GBC.gridx = 0;
        label1GBC.gridy = 1;
        label1GBC.gridwidth = 1;
        label1GBC.gridheight = 1;
        label1GBC.fill = GridBagConstraints.BOTH;
        companyTF = new JTextField(15);
        TF1GBC.gridx = 1;
        TF1GBC.gridy = 1;
        TF1GBC.gridwidth = 1;
        TF1GBC.gridheight = 1;
        TF1GBC.fill = GridBagConstraints.BOTH;
        TF1GBC.insets = new Insets(10, 10, 10, 10);

        billingInfoPnl.add(companyLbl, label1GBC);
        billingInfoPnl.add(companyTF, TF1GBC);

        streetLbl = new JLabel("Address Line 1:");
        label2GBC.gridx = 0;
        label2GBC.gridy = 2;
        label2GBC.gridwidth = 1;
        label2GBC.gridheight = 1;
        label2GBC.fill = GridBagConstraints.BOTH;
        streetTF = new JTextField(15);
        TF2GBC.gridx = 1;
        TF2GBC.gridy = 2;
        TF2GBC.gridwidth = 1;
        TF2GBC.gridheight = 1;
        TF2GBC.fill = GridBagConstraints.BOTH;
        TF2GBC.insets = new Insets(10, 10, 10, 10);

        billingInfoPnl.add(streetLbl, label2GBC);
        billingInfoPnl.add(streetTF, TF2GBC);

        aptLbl = new JLabel("Address Line 2 (Optional):");
        label3GBC.gridx = 0;
        label3GBC.gridy = 3;
        label3GBC.gridwidth = 1;
        label3GBC.gridheight = 1;
        label3GBC.fill = GridBagConstraints.BOTH;
        aptTF = new JTextField(15);
        TF3GBC.gridx = 1;
        TF3GBC.gridy = 3;
        TF3GBC.gridwidth = 1;
        TF3GBC.gridheight = 1;
        TF3GBC.fill = GridBagConstraints.BOTH;
        TF3GBC.insets = new Insets(10, 10, 10, 10);

        billingInfoPnl.add(aptLbl, label3GBC);
        billingInfoPnl.add(aptTF, TF3GBC);

        cityLbl = new JLabel("City:");
        label4GBC.gridx = 0;
        label4GBC.gridy = 4;
        label4GBC.gridwidth = 1;
        label4GBC.gridheight = 1;
        label4GBC.fill = GridBagConstraints.BOTH;
        cityTF = new JTextField(15);
        TF4GBC.gridx = 1;
        TF4GBC.gridy = 4;
        TF4GBC.gridwidth = 1;
        TF4GBC.gridheight = 1;
        TF4GBC.fill = GridBagConstraints.BOTH;
        TF4GBC.insets = new Insets(10, 10, 10, 10);

        billingInfoPnl.add(cityLbl, label4GBC);
        billingInfoPnl.add(cityTF, TF4GBC);

        stateLbl = new JLabel("State:");
        label5GBC.gridx = 0;
        label5GBC.gridy = 5;
        label5GBC.gridwidth = 1;
        label5GBC.gridheight = 1;
        label5GBC.fill = GridBagConstraints.BOTH;
        stateTF = new JTextField(15);
        TF5GBC.gridx = 1;
        TF5GBC.gridy = 5;
        TF5GBC.gridwidth = 1;
        TF5GBC.gridheight = 1;
        TF5GBC.fill = GridBagConstraints.BOTH;
        TF5GBC.insets = new Insets(10, 10, 10, 10);

        billingInfoPnl.add(stateLbl, label5GBC);
        billingInfoPnl.add(stateTF, TF5GBC);

        zipLbl = new JLabel("Zip Code:");
        label6GBC.gridx = 0;
        label6GBC.gridy = 6;
        label6GBC.gridwidth = 1;
        label6GBC.gridheight = 1;
        label6GBC.fill = GridBagConstraints.BOTH;
        zipTF = new JTextField(15);
        TF6GBC.gridx = 1;
        TF6GBC.gridy = 6;
        TF6GBC.gridwidth = 1;
        TF6GBC.gridheight = 1;
        TF6GBC.fill = GridBagConstraints.BOTH;
        TF6GBC.insets = new Insets(10, 10, 10, 10);

        billingInfoPnl.add(zipLbl, label6GBC);
        billingInfoPnl.add(zipTF, TF6GBC);

        mainPnl.add(billingInfoPnl, gbc);
    }

    /**
     * This method establishes the controlPnl, its GridBagConstraints, and the JButtons inside of it.
     * It also sets the ActionListeners for the buttons, which control most of the functional code in the frame.
     */
    private void createControlPnl()
    {
        controlPnl = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;

        controlPnl.setBorder(new CompoundBorder((new EtchedBorder()), new EmptyBorder(10, 10, 10, 10)));
        controlPnl.setLayout(new GridLayout(1, 3));

        submitBtn = new JButton("Submit");
        submitBtn.setBackground(new Color(42, 74, 147, 255));
        submitBtn.setForeground(new Color(255, 255, 255));
        clearBtn = new JButton("Clear Form");
        clearBtn.setBackground(new Color(42, 74, 147, 255));
        clearBtn.setForeground(new Color(255, 255, 255));
        quitBtn = new JButton("Quit");
        quitBtn.setBackground(new Color(42, 74, 147, 255));
        quitBtn.setForeground(new Color(255, 255, 255));

        controlPnl.add(submitBtn);
        submitBtn.addActionListener((ActionEvent ae) ->
        {
            //This algorithm checks if the form has been submitted before; if so, blocks the user from creating new invoices until the form is cleared
            if(!submitted)
            {
                //This algorithm checks if any mandatory billing fields are empty
                if (companyTF.getText().trim().isEmpty() || streetTF.getText().trim().isEmpty() || cityTF.getText().trim().isEmpty() || stateTF.getText().trim().isEmpty() || zipTF.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You must enter data into every Billing Information field that is not marked as optional before submitting your invoice.");
                } else {
                    //This String stores a RegEx pattern for checking that the user correctly entered a state
                    String regExState;

                    //This String stores a RegEx pattern for checking that the user correctly entered a zip code
                    String regExZip;

                    regExState = "[A-Z][A-Z]";
                    regExZip = "[0-9][0-9][0-9][0-9][0-9]";

                    //This algorithm checks that the input matches the RegEx
                    if (stateTF.getText().trim().matches(regExState) && zipTF.getText().trim().matches(regExZip)) {
                        //This algorithm checks if the apartment field is empty
                        if (aptTF.getText().trim().isEmpty()) {
                            //This Address stores the billing information entered by the user
                            Address custAddress = new Address(streetTF.getText().trim(), cityTF.getText().trim(), stateTF.getText().trim(), zipTF.getText().trim());

                            //This Customer stores the billing information and company name entered by the user
                            Customer cust = new Customer(companyTF.getText().trim(), custAddress);

                            //This Invoice stores and formats all the data entered by the user
                            Invoice finalInvoice = new Invoice(lineItems, cust);

                            compInvoiceTA.setText(finalInvoice.getFormattedInvoice());
                            submitted = true;
                        } else {
                            //This Address stores the billing information entered by the user
                            Address custAddress = new Address(streetTF.getText().trim(), aptTF.getText().trim(), cityTF.getText().trim(), stateTF.getText().trim(), zipTF.getText().trim());

                            //This Customer stores the billing information and company name entered by the user
                            Customer cust = new Customer(companyTF.getText().trim(), custAddress);

                            //This Invoice stores and formats all the data entered by the user
                            Invoice finalInvoice = new Invoice(lineItems, cust);

                            compInvoiceTA.setText(finalInvoice.getFormattedInvoice());
                            submitted = true;
                        }
                    } else if (!stateTF.getText().trim().matches(regExState) && !zipTF.getText().trim().matches(regExZip)) {
                        JOptionPane.showMessageDialog(null, "All data entered into the State field must consist of two capital letters (ex. CA, OH). All data entered into the Zip Code field must consist of 5 digits (ex., 45238).");
                    } else if (!stateTF.getText().trim().matches(regExState)) {
                        JOptionPane.showMessageDialog(null, "All data entered into the State field must consist of two capital letters (ex. CA, OH).");
                    } else {
                        JOptionPane.showMessageDialog(null, "All data entered into the Zip Code field must consist of 5 digits (ex., 45238).");
                    }
                }
            } else
            {
                JOptionPane.showMessageDialog(null, "To create another invoice, please click the Clear Form button, then add new data.");
            }
        });

        controlPnl.add(clearBtn);
        clearBtn.addActionListener((ActionEvent ae) ->
        {
            prodNameTF.setText("");
            unitPriceTF.setText("");
            quantityTF.setText("");
            lineItems.clear();

            companyTF.setText("");
            streetTF.setText("");
            aptTF.setText("");
            cityTF.setText("");
            stateTF.setText("");
            zipTF.setText("");
            submitted = false;

            compInvoiceTA.setText("");
        });

        controlPnl.add(quitBtn);
        quitBtn.addActionListener((ActionEvent ae) ->
        {
            //This int tracks whether the user confirmed or denied they wanted to quit the program
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            //This algorithm determines whether to quit the program based on the user's input
            if(selection == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Quitting the program...");
                System.exit(0);
            } else
            {
                JOptionPane.showMessageDialog(null, "The program will remain open.");
            }
        });

        mainPnl.add(controlPnl, gbc);
    }

    /**
     * This method establishes the outputPnl, its GridBagConstraints, and the JLabel and JTextArea inside it.
     */
    private void createOutputPnl()
    {
        outputPnl = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;

        outputPnl.setBorder(new CompoundBorder((new EtchedBorder()), new EmptyBorder(10, 10, 10, 10)));
        outputPnl.setLayout(new BorderLayout());

        compInvoiceLbl = new JLabel("Completed Invoice");
        compInvoiceLbl.setFont(subtitleFont);

        compInvoiceTA = new JTextArea(10, 50);
        compInvoiceTA.setEditable(false);
        compInvoiceTA.setFont(monospace);
        scroller = new JScrollPane(compInvoiceTA);

        outputPnl.add(compInvoiceLbl, BorderLayout.NORTH);
        outputPnl.add(scroller, BorderLayout.CENTER);
        mainPnl.add(outputPnl, gbc);
    }
}
