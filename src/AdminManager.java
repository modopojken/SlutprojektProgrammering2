import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * En klass som skapar admin managern där vi kommer kunna inserta ord till databasen (fast det funkar inte för jag hann inte så långt)
 */
public class AdminManager {

    private JTextField addWordsHereTextField;
    private JTextField guessrword;
    private JTextField guessrclue1;
    private JTextField guessrclue5552;
    private JTextField guessrclue3;
    private JTextField guessrclue4;
    private JTextField guessrclue5;
    private JButton addword;
    private JTextField rattord;
    private JTextField cluesTextField;
    private JPanel adminsak;
    private JButton ExitButton;
    JFrame frame;
    public int wordamount;

    /**
     * Dessa listners stänger ner programmet och plussar på wordamount.
     */
    public AdminManager() {
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        addword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                wordamount++; //Knappen man skickar in fler ord med, samt lägger till en till i wordammount
                                // Wordamount är hur många olika ord med ledgrådar som finns.
            }
        });
    }

    /**
     * Skapar admin manager GUIn där vi kan inserta ord till databasen i ord och clue fälten.
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("AdminManager");
        frame.setContentPane(new AdminManager().adminsak);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /*   public static void main(String[] args) {
            AdminManager ks = new AdminManager();
            ks.frame.setVisible(true);
        }*/

    /**
     *
     */
   public void createAdminManager() {
        frame = new JFrame("AdminManager");
        frame.setContentPane(new AdminManager().adminsak);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

}
