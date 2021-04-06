import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Eiman on 3/26/2021.
 */
public class DocSearch {
    public JPanel panel1;
    private JTable table1;
    private JTextField DI;
    private JButton se;
    String header[]={"Doctor_ID","Doctor_name","Clinic_ID","Clinic_name"};

    public DocSearch() {
        se.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model=new DefaultTableModel(0,4);
                model.setColumnIdentifiers(header);
                try {
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
                    Statement s=conn.createStatement();
                    String statement = "SELECT * FROM Doctor where Doctor_ID = '"+ DI.getText()+"'";
                    ResultSet rs = s.executeQuery(statement);
                    while (rs.next())
                    {

                        Object[] row={rs.getString("Doctor_ID"),rs.getString("Doctor_name"),rs.getString("Clinic_ID")
                                ,rs.getString("Clinic_name")};
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
        DefaultTableModel model=new DefaultTableModel(0,4);
        model.setColumnIdentifiers(header);
        table1=new JTable(model);
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s=conn.createStatement();
            String statement = "SELECT * FROM Doctor ";
            ResultSet rs = s.executeQuery(statement);
            while (rs.next())
            {

                Object[] row={rs.getString("Doctor_ID"),rs.getString("Doctor_name"),rs.getString("Clinic_ID")
                        ,rs.getString("Clinic_name")};
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
        f.add(new DocSearch().panel1);
        f.setVisible(true);
        f.setLocation(300,400);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
