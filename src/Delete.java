import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Eiman on 12/17/2020.
 */
public class Delete {
    ManagerOperation mo=new ManagerOperation();
    public JPanel panel1;
    private JTable table3;
    private JTextField pI;
    private JButton de;
    String header[]={"Registeration_ID","Patient_ID","Patient_name","Patient_age","Patient_gender","Doctor_ID",
            "Doctor_name","Pro_ID","Pro_name","Price","pro_desc","Clinic_ID","Clinic_name"};

    public Delete() {
        de.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mo.deleteRegisteration(pI.getText());
                DefaultTableModel model=new DefaultTableModel(0,13);
                model.setColumnIdentifiers(header);
                try {
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
                    Statement st=conn.createStatement();
                    String statement = "delete from Registeration where Patient_ID='"+ pI.getText()+"'";
                    int i=st.executeUpdate(statement);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                table3.setModel(model);
                table3.repaint();
                table3.revalidate();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model=new DefaultTableModel(0,13);
        model.setColumnIdentifiers(header);
        table3=new JTable(model);
        //try {
          ///  Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
           // Statement st=conn.createStatement();
           // String statement = "delete from Registeration ";
            //int i=st.executeUpdate(statement);

//        } catch (SQLException e) {
  //          e.printStackTrace();
    //    }
        table3=new JTable(model);
        table3.repaint();
        table3.revalidate();
        //  panel1.add(table2);
    }

    public static void main(String[] args) {
        JFrame f=new JFrame("Deleting Data");
        f.setSize(500,500);
        f.add(new Delete().panel1);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
