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
    private JPanel fuskknapp;
    private JTextField skrivDinGissningNedanförTextField;
    private JTextField ledareTextField;
    private JRadioButton fuskRadioButton;
    private JTextField rättsvar;

    String rättord = "tre";

    int score = 0;
    int AntalPoängSomGes = 5;
    int rättirad;
    int felirad;
    JFrame frame;

    public static void main(String[] args) {
        hejsansvejsan hs = new hejsansvejsan();

    }

    public hejsansvejsan() {
        System.out.println("starting");
        frame = new JFrame("hejsansvejsan");
        frame.setContentPane(this.fuskknapp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        skrivDinGissningHärTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Guess = skrivDinGissningHärTextField.getText();
                if(Guess.equals(rättord)){
                    score ++;
                    String svar = Integer.toString(score);
                    dinaPoängTextField.setText(svar);
                    System.out.println("rätt");
                    skrivDinGissningHärTextField.setText("");
                    felirad = 0;
                    rättirad++;
                    rättFelTextField.setText("Rätt! " + "Du har haft rätt " + rättirad + " gånger i rad!");
                    AntalPoängSomGes = 5;
                }else{
                    AntalPoängSomGes--;
                    felirad++;
                    String FelSvarPoäng = Integer.toString(AntalPoängSomGes);
                    antalPoängSomGesTextField.setText(FelSvarPoäng);
                    skrivDinGissningHärTextField.setText("");
                    rättFelTextField.setText("Fel! " + "Du har haft fel " + felirad + " gånger i rad!");
                    if (AntalPoängSomGes <= 0){

                        JOptionPane.showMessageDialog(null, "Du gissade fel för många gånger i rad.");
                        System.out.println("Exiting");
                        System.exit(1);
                    }

                }

            }
        });
        dinaPoängTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int yourscore = 1;

            }
        });
        fuskRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //rättsvar
            }
        });
    }
}
