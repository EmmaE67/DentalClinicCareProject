import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eiman on 3/30/2021.
 */
public class Menu {
    public JPanel panel1;
    private JButton P;
    private JButton Pro;
    private JButton D;
    private JButton C;
    private JButton R;

    public Menu() {
        P.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Adding Patient");
                f.setSize(600,600);
                f.add(new PatientFrame().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Adding Doctor");
                f.setSize(600,600);
                f.add(new DocFrame().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        R.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Adding Registration");
                f.setSize(600,600);
                f.add(new FORM().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Adding Clinic");
                f.setSize(600,600);
                f.add(new ClinicFrame().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        Pro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Adding Procedure");
                f.setSize(600, 600);
                f.add(new ProcedureFrame().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Menu of Dental Clinic");
        f.setSize(600,300);
        f.add(new Menu().panel1);
        f.setVisible(true);
        f.setLocation(400,100);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
