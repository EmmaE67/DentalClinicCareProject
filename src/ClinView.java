import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * Created by Eiman on 3/30/2021.
 */
public class ClinView {
    public JPanel panel1;
    private JTable table1;
    String header[]={"Clinic_ID","Clinic_name"};

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model=new DefaultTableModel(0,2);
        model.setColumnIdentifiers(header);
        table1=new JTable(model);
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery("select * from Clinic");
            while (rs.next())
            {
                Object[] row={rs.getString("Clinic_ID"),rs.getString("Clinic_name")};
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JFrame f=new JFrame("Clinic Data");
        f.setSize(5000,5000);
        f.add(new ClinView().panel1);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
