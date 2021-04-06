import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * Created by Eiman on 3/30/2021.
 */
public class ProView {
    public JPanel panel1;
    private JTable table1;
    String header[]={"Pro_ID","Pro_name","Price","pro_desc"};

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model=new DefaultTableModel(0,4);
        model.setColumnIdentifiers(header);
        table1=new JTable(model);
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery("select * from Procedure");
            while (rs.next())
            {
                Object[] row={rs.getString("Pro_ID"), rs.getString("Pro_name"),rs.getDouble("Price"),rs.getString("pro_desc")};
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        JFrame f=new JFrame("Procedure Data");
        f.setSize(5000,5000);
        f.add(new ProView().panel1);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
