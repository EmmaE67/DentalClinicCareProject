import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eiman on 3/30/2021.
 */
public class ClinicFrame {
    ManagerOperation mo=new ManagerOperation();
    public JPanel panel1;
    private JTextField ClD;
    private JTextField CN;
    private JButton a;
    private JButton d;
    private JButton s;
    private JButton v;

    public ClinicFrame() {
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mo.addClinic(ClD.getText(),CN.getText());
                System.out.println(ClD.getText()+"\n"+CN.getText());
            }
        });
        v.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Clinic Data");
                f.setSize(5000,5000);
                f.add(new ClinView().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Searching data");
                f.setSize(300,300);
                f.add(new ClinSearch().panel1);
                f.setVisible(true);
                f.setLocation(300,400);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            }
        });
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Deleting Data");
                f.setSize(500,500);
                f.add(new ClinDelete().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
    }
    public static void main(String[] args) {
        JFrame f=new JFrame("Adding Clinic");
        f.setSize(600,600);
        f.add(new ClinicFrame().panel1);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
