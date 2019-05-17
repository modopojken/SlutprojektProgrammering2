import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * En klASS som loggar in. Skapar ett loggin GUI.
 */
public class loginmanager {
    private JTextField WriteUsernametextField;
    private JTextField WritePasswordtextField;
    private JPasswordField passwordField;
    private JTextField UsernametextField;
    private JTextField loginBelowTextField;
    private JButton Loginbutton;
    JPanel loginsaken;
    private JButton loginBelowButton;
    hejsansvejsan hs;
    loginmanager hk;
    AdminManager ks;
    int blyat = 0;
    static JFrame frame;

    /**
     * Här skapas GUIt
     * @param args
     */
    public static void main(String[] args) {
        frame = new JFrame("loginmanager");
        frame.setContentPane(new loginmanager().loginsaken);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);


    }

    /**
     * Här har vi inloggnings listernersa
     */
    public loginmanager() {
        Loginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hs == null) {
                    hs = new hejsansvejsan();
                    blyat++;

                }
                hs.frame.setVisible(true);
                frame.setVisible(false); //Då du loggar in så göms "loginmanager" och "hejsansvejsan" visas
            }

        });

        loginBelowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ks == null) {
                    ks = new AdminManager();
                    ks.createAdminManager();
                    blyat++;                    //Här så göms loginmanager och adminmanager visas.

                }
                ks.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}
