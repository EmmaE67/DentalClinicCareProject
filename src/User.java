import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eiman on 12/22/2020.
 */
public class User {
    ManagerOperation mo=new ManagerOperation();
    private JTextField u;
    private JPasswordField pass;
    private JButton okButton;
    private JPanel Login;

    public User() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Menu of Dental Clinic");
                f.setSize(600, 600);
                f.add(new Menu().panel1);
                f.setVisible(true);
                f.setLocation(500,100);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
    }

    public static void main(String[] args) {
        JFrame f=new JFrame("Login to the program");
        f.setSize(300,200);
        f.add(new User().Login);
        f.setVisible(true);
        f.setLocation(500,100);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
