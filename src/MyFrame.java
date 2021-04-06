import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * Created by Eiman on 12/15/2020.
 */
public class MyFrame {
  public JPanel panel1;
    private JTable table1;
    String header[]={"Registeration_ID","Patient_ID","Patient_name","Patient_age","Patient_gender","Doctor_ID",
            "Doctor_name","Pro_ID","Pro_name","Price","pro_desc","Clinic_ID","Clinic_name"};

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model=new DefaultTableModel(0,13);
        model.setColumnIdentifiers(header);
        table1=new JTable(model);
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery("select * from Registeration");
            while (rs.next())
            {
                Object[] row={rs.getString("Registeration_ID"),rs.getString("Patient_ID"),rs.getString("Patient_name"),rs.getString("Patient_age")
                ,rs.getString("Patient_gender"),rs.getString("Doctor_ID"),rs.getString("Doctor_name"),rs.getString("Pro_ID"),
                        rs.getString("Pro_name"),rs.getDouble("Price"),rs.getString("pro_desc"),rs.getString("Clinic_ID")
                ,rs.getString("Clinic_name")};
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame f=new JFrame("Registeration Data");
        f.setSize(5000,5000);
        f.add(new MyFrame().panel1);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
