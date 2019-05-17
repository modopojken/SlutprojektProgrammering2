import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * En klass som skapar spelet, här kommer vi se ledtrådar, skriva gissningar och se om vi hade rätt eller fel.
 */
public class hejsansvejsan {
    private JButton exitButton;
    private JTextField skrivDinGissningHarTextField;
    private JTextField gissaOrdetTextField;
    private JTextArea härKommerLedtradarnaTextArea;
    private JTextArea spelareSomarMedTextArea;
    private JTextField antalPoangSomGesTextField;
    private JTextField dinaPoangTextField;
    private JTextField antalLedtradarUteTextField;
    private JTextField rattFelTextField;
    private JPanel fuskknapp;
    private JTextField skrivDinGissningNedanforTextField;
    private JTextField ledareTextField;
    private JRadioButton fuskRadioButton;
    private JTextField rattsvar;
    spel s;


    int score = 0;
    int AntalPoangSomGes = 5;
    int rattirad;
    int felirad;
    JFrame frame;

    public static void main(String[] args) {
        hejsansvejsan hs = new hejsansvejsan();


    }

    /**
     * Denna skapar GUI interfacet.
     */
    public hejsansvejsan() {
        System.out.println("starting");
        s = new spel();
        s.init();
        frame = new JFrame("hejsansvejsan");
        frame.setContentPane(this.fuskknapp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(false);     //Hejsansvejsan är inte synlig från början för att man börjar på loginmanager och inte denna

        int secondPassed = 0;
        double startTime = System.currentTimeMillis();
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        skrivDinGissningHarTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Guess = skrivDinGissningHarTextField.getText();
                if(Guess.equals(s.getWord())){
                    score ++;
                    String svar = Integer.toString(score);
                    dinaPoangTextField.setText(svar);
                    System.out.println("rätt"); //skriver ut rätt om du har rätt
                    skrivDinGissningHarTextField.setText(""); //sätter textfieldet till blankt efter du submitar ditt svar
                    felirad = 0; //Sätter felirad till 0 då du svarar rätt
                    rattirad++;     //Räknar rätt i rad
                    rattFelTextField.setText("Rätt! " + "Du har haft rätt " + rattirad + " gånger i rad!");
                    AntalPoangSomGes = 5;
                }else{
                    AntalPoangSomGes--;
                    felirad++; //räknar hur många gånger du har svarat fel i rad
                    String FelSvarPoäng = Integer.toString(AntalPoangSomGes);
                    antalPoangSomGesTextField.setText(FelSvarPoäng);
                    skrivDinGissningHarTextField.setText(""); //tar bort det man skrev innan och gör raden blank
                    rattFelTextField.setText("Fel! " + "Du har haft fel " + felirad + " gånger i rad!");
                    if (AntalPoangSomGes <= 0){

                        JOptionPane.showMessageDialog(null, "Du gissade fel för många gånger i rad.");
                        System.out.println("Exiting");
                        System.exit(1);                 //Detta är det som sker när man svarar fel flera gånger i rad.
                    }

                }

            }
        });
        /**
         * Här har vi listersena till GUIn där vi spelar spelet.
         */
        dinaPoangTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int yourscore = 1;

            }
        });
        fuskRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //rattsvar
            }
        });
        spelareSomarMedTextArea.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                spelareSomarMedTextArea.setText("Endast du.");
            }
        });
        härKommerLedtradarnaTextArea.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                härKommerLedtradarnaTextArea.setText(s.getClue1());
                if (System.currentTimeMillis()-startTime >= 5000){
                    härKommerLedtradarnaTextArea.setText("");       // Misslyckat försök på timer
                    härKommerLedtradarnaTextArea.setText(s.getClue1() + "\n" + s.getClue2());
                }

            }
        });
        härKommerLedtradarnaTextArea.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int ettTal = 1;
                if (ettTal == 1){
                    härKommerLedtradarnaTextArea.setText(s.getClue1() + "\n" + s.getClue2() + "\n" + s.getClue3() + "\n" + s.getClue4() + "\n" + s.getClue5());
                    // Här displayar vi alla ledtrådar
                }
            }
        });
    }
}
