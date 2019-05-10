import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.TimerTask;

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
    spel s;


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
        s = new spel();
        s.init();
        frame = new JFrame("hejsansvejsan");
        frame.setContentPane(this.fuskknapp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(false);
        int secondPassed = 0;
        double startTime = System.currentTimeMillis();
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
                if(Guess.equals(s.getWord())){
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
        spelareSomÄrMedTextArea.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                spelareSomÄrMedTextArea.setText("Endast du.");
            }
        });
        härKommerLedtrådarnaTextArea.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                härKommerLedtrådarnaTextArea.setText(s.getClue1());
                if (System.currentTimeMillis()-startTime >= 5000){
                    härKommerLedtrådarnaTextArea.setText("");
                    härKommerLedtrådarnaTextArea.setText(s.getClue1() + "\n" + s.getClue2());
                }

            }
        });
    }
}
