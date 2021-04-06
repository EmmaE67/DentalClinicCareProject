import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

/**
 * Created by SR on 15/12/2020.
 */
public class FORM {
   ManagerOperation mo=new ManagerOperation();
    public JPanel panel1;
    private JTextField rI;
    private JTextField pI;
    private JTextField pn;
    private JTextField pa;
    private JTextField dI;
    private JTextField dn;
    private JTextField prI;
    private JTextField prn;
    private JTextField prp;
    private JTextField pd;
    private JTextField cI;
    private JTextField cn;
    private JButton addButton;
    private JButton c;
    private JTextField g;
    private JRadioButton fe;
    private JRadioButton male;
    private JButton searchButton;
    private JButton deleteButton;


    public FORM() {
        ButtonGroup g= new ButtonGroup();
        g.add(fe);
        g.add(male);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double p = Double.parseDouble(prp.getText());
                String s;
              if(male.isSelected())
              {
                  s="Male";
              }

                else
                    s="Female";

                mo.addRegist(rI.getText(),pI.getText(),pn.getText(),pa.getText()
                        ,s,dI.getText(),dn.getText(),prI.getText()
                        ,prn.getText(),p,pd.getText(),cI.getText(),cn.getText());
                System.out.println(rI.getText()+"\n"+pI.getText()+"\n"+pn.getText()+"\n"+pa.getText()
                                +"\n"+s+"\n"+dI.getText()+"\n"+dn.getText()+"\n"+prI.getText()
                        +"\n"+prn.getText()+"\n"+p+"\n"+pd.getText()+"\n"+cI.getText()+"\n"+cn.getText());

                }

            }
        );
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame();
                f.setSize(5000,5000);
                f.add(new MyFrame().panel1);
                f.setVisible(true);

            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Searching Date");
                f.setSize(900,500);
                f.add(new Search().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("Deleting Data");
                f.setSize(900,500);
                f.add(new Delete().panel1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
    }

    public static void main(String[] args) {
        JFrame f=new JFrame("Adding Registration");
        f.setSize(600,600);
        f.add(new FORM().panel1);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
