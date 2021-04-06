import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eiman on 3/26/2021.
 */
public class PatientFrame {
    ManagerOperation mo=new ManagerOperation();
    private JTextField PI;
    private JTextField PA;
    private JTextField PN;
    private JRadioButton f;
    private JRadioButton m;
    private JButton v;
    private JButton a;
    public JPanel panel1;
    private JButton d;
    private JButton s;

    public PatientFrame() {
        ButtonGroup g= new ButtonGroup();
        g.add(f);
        g.add(m);
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s;
                if(m.isSelected())
                {
                    s="Male";
                }

                else
                    s="Female";

                mo.addPatient(PI.getText(),PN.getText(),PA.getText(),s);
            }
        });
        v.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Patient Data");
                f.setSize(5000,5000);
                f.add(new PatView().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Deleting Data");
                f.setSize(500,500);
                f.add(new PatDelete().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Searching data");
                f.setSize(300,300);
                f.add(new PatSearch().panel1);
                f.setVisible(true);
                f.setLocation(300,400);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
    }

    public static void main(String[] args) {
        JFrame f=new JFrame("Adding Patient");
        f.setSize(600,600);
        f.add(new PatientFrame().panel1);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
