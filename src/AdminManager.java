import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminManager {

    private JTextField addWordsHereTextField;
    private JTextField guessrword;
    private JTextField guessrclue1;
    private JTextField guessrclue5552;
    private JTextField guessrclue3;
    private JTextField guessrclue4;
    private JTextField guessrclue5;
    private JButton addword;
    private JTextField rättord;
    private JTextField cluesTextField;
    private JPanel adminsak;
    private JButton ExitButton;
    JFrame frame;
    public int wordamount;

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

                wordamount++;
            }
        });
    }

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
   public void createAdminManager() {
        frame = new JFrame("AdminManager");
        frame.setContentPane(new AdminManager().adminsak);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

}
