import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Eiman on 3/26/2021.
 */
public class PatSearch {
    public JPanel panel1;
    private JTable table1;
    private JTextField PI;
    private JButton s;
    String header[]={"Patient_ID","Patient_name","Patient_age","Patient_gender"};

    public PatSearch() {
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // mo.searchRegisteration(pI.getText());
                DefaultTableModel model=new DefaultTableModel(0,4);
                model.setColumnIdentifiers(header);
                try {
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
                    Statement s=conn.createStatement();
                    String statement = "SELECT * FROM Patient where Patient_ID = '"+ PI.getText()+"'";
                    ResultSet rs = s.executeQuery(statement);
                    while (rs.next())
                    {

                        Object[] row={rs.getString("Patient_ID"),rs.getString("Patient_name"),rs.getString("Patient_age")
                                ,rs.getString("Patient_gender")};
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
        // mo.searchRegisteration(pI.getText());
        DefaultTableModel model=new DefaultTableModel(0,4);
        model.setColumnIdentifiers(header);
        table1=new JTable(model);
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s=conn.createStatement();
            String statement = "SELECT * FROM Patient ";
            ResultSet rs = s.executeQuery(statement);
            while (rs.next())
            {

                Object[] row={rs.getString("Patient_ID"),rs.getString("Patient_name"),rs.getString("Patient_age")
                        ,rs.getString("Patient_gender")};
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
        f.add(new PatSearch().panel1);
        f.setVisible(true);
        f.setLocation(300,400);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
