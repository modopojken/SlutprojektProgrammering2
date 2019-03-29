import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hejsansvejsan {
    private JButton exitButton;
    private JTextField skrivDinGissningHärTextField;
    private JTextField gissaOrdetTextField;
    private JTextArea härKommerLedtrådarnaTextArea;
    private JTextArea spelareSomÄrMedTextArea;
    private JTextField antalPoängSomGesTextField;
    private JTextField dinaPoängTextField;
    private JTextField antalLedtrådarUteTextField;
    private JTextField rättFelTextField;
    private JPanel Panelen;

    public static void main(String[] args) {
        JFrame frame = new JFrame("hejsansvejsan");
        frame.setContentPane(new hejsansvejsan().Panelen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public hejsansvejsan() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
