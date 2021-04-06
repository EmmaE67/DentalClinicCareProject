import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eiman on 3/30/2021.
 */
public class ProcedureFrame {
    ManagerOperation mo = new ManagerOperation();
    public JPanel panel1;
    private JTextField ProID;
    private JTextField Pro_des;
    private JTextField Pr;
    private JTextField ProN;
    private JButton a;
    private JButton v;
    private JButton s;
    private JButton d;


    public ProcedureFrame() {
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double p = Double.parseDouble(Pr.getText());
                mo.addProcedure(ProID.getText(), ProN.getText(), p, Pro_des.getText());
                System.out.println(ProID.getText()
                        + "\n" + ProN.getText() + "\n" + p + "\n" + Pro_des.getText());
            }
        });
        v.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Procedure Data");
                f.setSize(5000, 5000);
                f.add(new ProView().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            }
        });
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Searching data");
                f.setSize(300,300);
                f.add(new ProSearch().panel1);
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
                f.add(new ProDelete().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
    }


    public static void main(String[] args) {
        JFrame f = new JFrame("Adding Procedure");
        f.setSize(600, 600);
        f.add(new ProcedureFrame().panel1);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}