import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * Created by Eiman on 3/26/2021.
 */
public class PatView {
    public JPanel panel1;
    private JTable table1;
    String header[]={"Patient_ID","Patient_name","Patient_age","Patient_gender"};

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model=new DefaultTableModel(0,13);
        model.setColumnIdentifiers(header);
        table1=new JTable(model);
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery("select * from Patient");
            while (rs.next())
            {
                Object[] row={rs.getString("Patient_ID"),rs.getString("Patient_name"),rs.getString("Patient_age")
                        ,rs.getString("Patient_gender")};
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        JFrame f=new JFrame("Patient Data");
        f.setSize(5000,5000);
        f.add(new PatView().panel1);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
