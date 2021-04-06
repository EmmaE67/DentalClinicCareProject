import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Eiman on 12/17/2020.
 */
public class Search {
    ManagerOperation mo=new ManagerOperation();
    public JPanel panel1;
    private JTable table2;
    private JTextField pI;
    private JButton se;
    String header[]={"Registeration_ID","Patient_ID","Patient_name","Patient_age","Patient_gender","Doctor_ID",
            "Doctor_name","Pro_ID","Pro_name","Price","pro_desc","Clinic_ID","Clinic_name"};


    public Search() {

        se.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // mo.searchRegisteration(pI.getText());
                DefaultTableModel model=new DefaultTableModel(0,13);
                model.setColumnIdentifiers(header);
                try {
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
                    Statement s=conn.createStatement();
                    String statement = "SELECT * FROM Registeration where Patient_ID = '"+ pI.getText()+"'";
                    ResultSet rs = s.executeQuery(statement);
                    while (rs.next())
                    {

                        Object[] row={rs.getString("Registeration_ID"),rs.getString("Patient_ID"),rs.getString("Patient_name"),rs.getString("Patient_age")
                                ,rs.getString("Patient_gender"),rs.getString("Doctor_ID"),rs.getString("Doctor_name"),rs.getString("Pro_ID"),
                                rs.getString("Pro_name"),rs.getDouble("Price"),rs.getString("pro_desc"),rs.getString("Clinic_ID")
                                ,rs.getString("Clinic_name")};
                        model.addRow(row);

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                table2.setModel(model);
                table2.repaint();
                table2.revalidate();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model=new DefaultTableModel(0,13);
        model.setColumnIdentifiers(header);
        table2=new JTable(model);
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s=conn.createStatement();
            String statement = "SELECT * FROM Registeration ";
            ResultSet rs = s.executeQuery(statement);
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
        table2=new JTable(model);
        table2.repaint();
        table2.revalidate();
        //  panel1.add(table2);
    }

    public static void main(String[] args) {
        JFrame f=new JFrame("Searching data");
        f.setSize(300,300);
        f.add(new Search().panel1);
        f.setVisible(true);
        f.setLocation(300,400);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
