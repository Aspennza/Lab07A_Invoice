import javax.swing.*;

public class InvoiceFrame extends javax.swing.JFrame
{
    JPanel mainPnl;
    JPanel titlePnl;
    JPanel productInfoPnl;
    JPanel billingInfoPnl;
    JPanel controlPnl;
    JPanel outputPnl;

    JLabel titleLbl;

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
}
