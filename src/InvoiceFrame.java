import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

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
    JLabel cityLbl;
    JLabel stateLbl;
    JLabel zipLbl;
    JTextField companyTF;
    JTextField streetTF;
    JTextField cityTF;
    JTextField stateTF;
    JTextField zipTF;

    JButton submitBtn;
    JButton clearBtn;
    JButton quitBtn;

    JLabel compInvoiceLbl;
    JTextArea compInvoiceTA;

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

        streetLbl = new JLabel("Street address:");
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

        cityLbl = new JLabel("City:");
        label3GBC.gridx = 0;
        label3GBC.gridy = 3;
        label3GBC.gridwidth = 1;
        label3GBC.gridheight = 1;
        label3GBC.fill = GridBagConstraints.BOTH;
        cityTF = new JTextField(15);
        TF3GBC.gridx = 1;
        TF3GBC.gridy = 3;
        TF3GBC.gridwidth = 1;
        TF3GBC.gridheight = 1;
        TF3GBC.fill = GridBagConstraints.BOTH;

        billingInfoPnl.add(cityLbl, label3GBC);
        billingInfoPnl.add(cityTF, TF3GBC);

        stateLbl = new JLabel("State:");
        label4GBC.gridx = 0;
        label4GBC.gridy = 4;
        label4GBC.gridwidth = 1;
        label4GBC.gridheight = 1;
        label4GBC.fill = GridBagConstraints.BOTH;
        stateTF = new JTextField(15);
        TF4GBC.gridx = 1;
        TF4GBC.gridy = 4;
        TF4GBC.gridwidth = 1;
        TF4GBC.gridheight = 1;
        TF4GBC.fill = GridBagConstraints.BOTH;

        billingInfoPnl.add(stateLbl, label4GBC);
        billingInfoPnl.add(stateTF, TF4GBC);

        zipLbl = new JLabel("Zip Code:");
        label5GBC.gridx = 0;
        label5GBC.gridy = 5;
        label5GBC.gridwidth = 1;
        label5GBC.gridheight = 1;
        label5GBC.fill = GridBagConstraints.BOTH;
        zipTF = new JTextField(15);
        TF5GBC.gridx = 1;
        TF5GBC.gridy = 5;
        TF5GBC.gridwidth = 1;
        TF5GBC.gridheight = 1;
        TF5GBC.fill = GridBagConstraints.BOTH;

        billingInfoPnl.add(zipLbl, label5GBC);
        billingInfoPnl.add(zipTF, TF5GBC);

        mainPnl.add(billingInfoPnl, gbc);
    }
}
