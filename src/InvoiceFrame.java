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

    JLabel prodInfoLbl;
    Font prodInfoFont;
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

        GridBagConstraints titleGBC = new GridBagConstraints();
        GridBagConstraints label1GBC = new GridBagConstraints();
        GridBagConstraints TF1GBC = new GridBagConstraints();
        GridBagConstraints label2GBC = new GridBagConstraints();
        GridBagConstraints TF2GBC = new GridBagConstraints();
        GridBagConstraints label3GBC = new GridBagConstraints();
        GridBagConstraints TF3GBC = new GridBagConstraints();

        productInfoPnl.setBorder(new EtchedBorder());
        productInfoPnl.setLayout(new GridBagLayout());

        prodInfoLbl = new JLabel("Product Information");
        prodInfoFont = new Font("Serif", Font.BOLD, 25);
        prodInfoLbl.setFont(prodInfoFont);
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
}
