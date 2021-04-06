import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Eiman on 3/26/2021.
 */
public class PatDelete {
    public JPanel panel1;
    private JTable table1;
    private JTextField PI;
    private JButton d;
    String header[]={"Patient_ID","Patient_name","Patient_age","Patient_gender"};

    public PatDelete() {
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mo.deleteRegisteration(pI.getText());
                DefaultTableModel model=new DefaultTableModel(0,4);
                model.setColumnIdentifiers(header);
                try {
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
                    Statement st=conn.createStatement();
                    String statement = "delete from Patient where Patient_ID='"+ PI.getText()+"'";
                    int i=st.executeUpdate(statement);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                table1.setModel(model);
                table1.repaint();
                table1.revalidate();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model=new DefaultTableModel(0,4);
        model.setColumnIdentifiers(header);
        table1=new JTable(model);
        //try {
        ///  Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
        // Statement st=conn.createStatement();
        // String statement = "delete from Registeration ";
        //int i=st.executeUpdate(statement);

//        } catch (SQLException e) {
        //          e.printStackTrace();
        //    }
        table1=new JTable(model);
        table1.repaint();
        table1.revalidate();
        //  panel1.add(table2);
    }

    public static void main(String[] args) {
        JFrame f=new JFrame("Deleting Data");
        f.setSize(500,500);
        f.add(new PatDelete().panel1);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
