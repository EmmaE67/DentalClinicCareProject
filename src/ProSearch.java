import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Eiman on 3/30/2021.
 */
public class ProSearch {
    public JPanel panel1;
    private JTable table1;
    private JTextField ProID;
    private JButton se;
    String header[]={"Pro_ID","Pro_name","Price","pro_desc"};

    public ProSearch() {
        se.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // mo.searchRegisteration(pI.getText());
                DefaultTableModel model=new DefaultTableModel(0,4);
                model.setColumnIdentifiers(header);
                try {
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
                    Statement s=conn.createStatement();
                    String statement = "SELECT * FROM Procedure where Pro_ID = '"+ ProID.getText()+"'";
                    ResultSet rs = s.executeQuery(statement);
                    while (rs.next())
                    {

                        Object[] row={rs.getString("Pro_ID"),rs.getString("Pro_name"),rs.getDouble("Price"),rs.getString("pro_desc")};
                        model.addRow(row);

                    }
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
        DefaultTableModel model=new DefaultTableModel(0,13);
        model.setColumnIdentifiers(header);
        table1=new JTable(model);
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s=conn.createStatement();
            String statement = "SELECT * FROM Procedure ";
            ResultSet rs = s.executeQuery(statement);
            while (rs.next())
            {

                Object[] row={rs.getString("Pro_ID"),rs.getString("Pro_name"),rs.getDouble("Price"),rs.getString("pro_desc")};
                model.addRow(row);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table1=new JTable(model);
        table1.repaint();
        table1.revalidate();
        //  panel1.add(table2);

    }
    public static void main(String[] args) {
        JFrame f=new JFrame("Searching data");
        f.setSize(300,300);
        f.add(new ProSearch().panel1);
        f.setVisible(true);
        f.setLocation(300,400);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
