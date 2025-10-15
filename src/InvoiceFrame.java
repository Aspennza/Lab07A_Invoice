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
    }
}
