import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Eiman on 3/30/2021.
 */
public class ClinSearch {
    public JPanel panel1;
    private JTable table1;
    private JTextField C_ID;
    private JButton de;
    String header[]={"Clinic_ID","Clinic_name"};

    public ClinSearch() {
        de.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // mo.searchRegisteration(pI.getText());
                DefaultTableModel model=new DefaultTableModel(0,2);
                model.setColumnIdentifiers(header);
                try {
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
                    Statement s=conn.createStatement();
                    String statement = "SELECT * FROM Clinic where Clinic_ID = '"+ C_ID.getText()+"'";
                    ResultSet rs = s.executeQuery(statement);
                    while (rs.next())
                    {

                        Object[] row={rs.getString("Clinic_ID"),rs.getString("Clinic_name")};
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
            String statement = "SELECT * FROM Clinic ";
            ResultSet rs = s.executeQuery(statement);
            while (rs.next())
            {

                Object[] row={rs.getString("Clinic_ID"),rs.getString("Clinic_name")};
                model.addRow(row);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table1=new JTable(model);
        table1.repaint();
        table1.revalidate();
    }
    public static void main(String[] args) {
        JFrame f=new JFrame("Searching data");
        f.setSize(300,300);
        f.add(new ClinSearch().panel1);
        f.setVisible(true);
        f.setLocation(300,400);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
