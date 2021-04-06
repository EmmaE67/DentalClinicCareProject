import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eiman on 3/25/2021.
 */
public class DocFrame {
    ManagerOperation mo=new ManagerOperation();
    public JPanel panel1;
    private JTextField dI;
    private JTextField cI;
    private JTextField dn;
    private JTextField cn;
    private JButton searchbutton;
    private JButton addbutton;
    private JButton viewbutton;
    private JButton deletebutton;

    public DocFrame() {
        addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mo.addDoc(dI.getText(),dn.getText(),cI.getText(),cn.getText());
            }
        });
        viewbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Doctor Data");
                f.setSize(5000,5000);
                f.add(new DocView().panel);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });

        deletebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Deleting Data");
                f.setSize(500,500);
                f.add(new DocDelete().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }

        });

        searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Searching data");
                f.setSize(300,300);
                f.add(new DocSearch().panel1);
                f.setVisible(true);
                f.setLocation(300,400);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
    }
    public static void main(String[] args) {
        JFrame f=new JFrame("Adding Doctor");
        f.setSize(600,600);
        f.add(new DocFrame().panel1);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
