import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InvoiceFrame extends javax.swing.JFrame
{
    JPanel mainPnl;
    JPanel titlePnl;
    JPanel productInfoPnl;
    JPanel billingInfoPnl;
    JPanel controlPnl;
    JPanel outputPnl;

    JLabel titleLbl;
    Font titlePnlFont;

    Font subtitleFont = new Font("Serif", Font.BOLD, 25);

    JLabel prodInfoLbl;
    JLabel prodNameLbl;
    JLabel unitPriceLbl;
    JLabel quantityLbl;
    JTextField prodNameTF;
    JTextField unitPriceTF;
    JTextField quantityTF;

    JLabel billingInfoLbl;
    JLabel companyLbl;
    JLabel streetLbl;
    JLabel aptLbl;
    JLabel cityLbl;
    JLabel stateLbl;
    JLabel zipLbl;
    JTextField companyTF;
    JTextField streetTF;
    JTextField aptTF;
    JTextField cityTF;
    JTextField stateTF;
    JTextField zipTF;

    JButton submitBtn;
    JButton clearBtn;
    JButton quitBtn;

    JLabel compInvoiceLbl;
    JTextArea compInvoiceTA;
    JScrollPane scroller;

    GridBagConstraints gbc = new GridBagConstraints();

    GridBagConstraints titleGBC = new GridBagConstraints();
    GridBagConstraints label1GBC = new GridBagConstraints();
    GridBagConstraints TF1GBC = new GridBagConstraints();
    GridBagConstraints label2GBC = new GridBagConstraints();
    GridBagConstraints TF2GBC = new GridBagConstraints();
    GridBagConstraints label3GBC = new GridBagConstraints();
    GridBagConstraints TF3GBC = new GridBagConstraints();
    GridBagConstraints label4GBC = new GridBagConstraints();
    GridBagConstraints TF4GBC = new GridBagConstraints();
    GridBagConstraints label5GBC = new GridBagConstraints();
    GridBagConstraints TF5GBC = new GridBagConstraints();
    GridBagConstraints label6GBC = new GridBagConstraints();
    GridBagConstraints TF6GBC = new GridBagConstraints();

    public InvoiceFrame()
    {
        super("Invoice Creator");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        mainPnl = new JPanel();
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

    private void createTitlePnl()
    {
        titlePnl = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;

        titlePnl.setBorder(new EtchedBorder());

        titleLbl = new JLabel("Invoice Creator");
        titlePnlFont = new Font("Serif", Font.BOLD, 48);
        titleLbl.setFont(titlePnlFont);

        titlePnl.add(titleLbl);
        mainPnl.add(titlePnl, gbc);
    }

    private void createProductInfoPnl()
    {
        productInfoPnl = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;

        productInfoPnl.setBorder(new EtchedBorder());
        productInfoPnl.setLayout(new GridBagLayout());

        prodInfoLbl = new JLabel("Product Information");

        prodInfoLbl.setFont(subtitleFont);
        titleGBC.gridx = 0;
        titleGBC.gridy = 0;
        titleGBC.gridwidth = 2;
        titleGBC.gridheight = 1;
        titleGBC.fill = GridBagConstraints.BOTH;
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

        productInfoPnl.add(quantityLbl, label3GBC);
        productInfoPnl.add(quantityTF, TF3GBC);
        mainPnl.add(productInfoPnl, gbc);
    }

    private void createBillingInfoPnl()
    {
        billingInfoPnl = new JPanel();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;

        billingInfoPnl.setBorder(new EtchedBorder());
        billingInfoPnl.setLayout(new GridBagLayout());

        billingInfoLbl = new JLabel("Billing Information");
        billingInfoLbl.setFont(subtitleFont);
        titleGBC.gridx = 0;
        titleGBC.gridy = 0;
        titleGBC.gridwidth = 2;
        titleGBC.gridheight = 1;
        titleGBC.fill = GridBagConstraints.BOTH;

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

        billingInfoPnl.add(zipLbl, label6GBC);
        billingInfoPnl.add(zipTF, TF6GBC);

        mainPnl.add(billingInfoPnl, gbc);
    }

    private void createControlPnl()
    {
        controlPnl = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;

        controlPnl.setBorder(new EtchedBorder());
        controlPnl.setLayout(new GridLayout(1, 3));

        submitBtn = new JButton("Submit");
        clearBtn = new JButton("Clear Form");
        quitBtn = new JButton("Quit");

        controlPnl.add(submitBtn);
        submitBtn.addActionListener((ActionEvent ae) ->
        {
            if (prodNameTF.getText().trim().isEmpty() || unitPriceTF.getText().trim().isEmpty() || quantityTF.getText().trim().isEmpty() || companyTF.getText().trim().isEmpty() || streetTF.getText().trim().isEmpty() || cityTF.getText().trim().isEmpty() || stateTF.getText().trim().isEmpty() || zipTF.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "You must enter data into every field that is not marked as optional before submitting.");
            } else {
                double unitPrice;
                int quantity;
                String regExState;
                String regExZip;
                try {
                    unitPrice = Double.parseDouble(unitPriceTF.getText().trim());
                    quantity = Integer.parseInt(quantityTF.getText().trim());
                    regExState = "[A-Z][A-Z]";
                    regExZip = "[0-9][0-9][0-9][0-9][0-9]";

                    if(stateTF.getText().trim().matches(regExState) && zipTF.getText().trim().matches(regExZip))
                    {
                        Product product = new Product(prodNameTF.getText().trim(), unitPrice);

                    } else if (!stateTF.getText().trim().matches(regExState) && !zipTF.getText().trim().matches(regExZip)) {
                        JOptionPane.showMessageDialog(null, "All data entered into the State field must consist of two capital letters (ex. CA, OH). All data entered into the Zip Code field must consist of 5 digits (ex., 45238).");
                    } else if (!stateTF.getText().trim().matches(regExState)) {
                        JOptionPane.showMessageDialog(null, "All data entered into the State field must consist of two capital letters (ex. CA, OH).");
                    } else {
                        JOptionPane.showMessageDialog(null, "All data entered into the Zip Code field must consist of 5 digits (ex., 45238).");
                    }

                } catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Values in the Product Unit Price and Quantity fields must be written using digits (1, 2, 3, etc.) only. Values for Quantity must be whole numbers.");
                }


                Invoice invoiceMsg = new Invoice();
            }
        });

        controlPnl.add(clearBtn);
        clearBtn.addActionListener((ActionEvent ae) ->
        {
            //actionlistener code here
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

    private void createOutputPnl()
    {
        outputPnl = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;

        outputPnl.setBorder(new EtchedBorder());
        outputPnl.setLayout(new BorderLayout());

        compInvoiceLbl = new JLabel("Completed Invoice");
        compInvoiceLbl.setFont(subtitleFont);

        compInvoiceTA = new JTextArea(10, 50);
        compInvoiceTA.setEditable(false);
        scroller = new JScrollPane(compInvoiceTA);

        outputPnl.add(compInvoiceLbl, BorderLayout.NORTH);
        outputPnl.add(scroller, BorderLayout.CENTER);
        mainPnl.add(outputPnl, gbc);
    }
}
