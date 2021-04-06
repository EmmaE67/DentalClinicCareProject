import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;

/**
 * Created by Eiman on 12/16/2020.
 */
public class DriverClass {
    Connection conn ;
    ArrayList<Registeration> registerations = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    ArrayList<Patient> patients = new ArrayList<>();
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Clinic> clinics = new ArrayList<>();
    ArrayList<Procedures> procedure = new ArrayList<>();

    public void addRegisteration() {
        System.out.println("Enter the Registeration ID");
        String r_Id = input.next();
        System.out.println("Enter the Patient ID");
        String pID = input.next();
        System.out.println("Enter the Patient Name");
        String pN = input.next();
        System.out.println("Enter the Patient Age");
        String pA = input.next();
        System.out.println("Enter the Patient Gender");
        String pg = input.next();
        System.out.println("Enter the Doctor ID");
        String dId = input.next();
        System.out.println("Enter the Doctor Name");
        String dN = input.next();
        System.out.println("Enter the Procedure ID");
        String prID = input.next();
        System.out.println("Enter the Procedure Name");
        String prN = input.next();
        System.out.println("Enter the Procedure Price");
        double pr = input.nextDouble();
        System.out.println("Enter the Procedure Description");
        String pro_d = input.next();
        System.out.println("Enter the Clinic ID");
        String cID = input.next();
        System.out.println("Enter the Clinic Name");
        String cN = input.next();
        registerations.add(new Registeration(r_Id, pID, pN, pA, pg, dId, dN, prID, prN, pr, pro_d, cID, cN));
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            s=conn.prepareStatement("insert into Registeration values('"+r_Id+"','" + pID+ "','"+
                    pN+ "','" +pA + "','"+ pg + "','"+
                    dId + "','"+ dN + "','"+ prID+ "','" +prN +
                    "',"+pr+ ",'"+ pro_d+ "','"+ cID+ "','"+ cN+"')");
            s.execute();
            System.out.println("Row is added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        view();
    }
    public void addRegist(String r_Id, String pID, String pN, String pA, String pg,
                                 String dId, String dN,
                                 String prID, String prN, double pr, String pro_d,
                                 String cID, String cN) {

        registerations.add(new Registeration(r_Id, pID, pN, pA, pg, dId, dN, prID, prN, pr, pro_d, cID, cN));
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            s=conn.prepareStatement("insert into Registeration values('"+r_Id+"','" + pID+ "','"+
                    pN+ "','" +pA + "','"+ pg + "','"+
                    dId + "','"+ dN + "','"+ prID+ "','" +prN +
                    "',"+pr+ ",'"+ pro_d+ "','"+ cID+ "','"+ cN+"')");
            s.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        view();
    }

    public void view() {
        for (Registeration r : registerations) {
            System.out.println(r);
        }
    }

    public void viewRegisteration()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Registeration");
            while(rs.next())

                System.out.println(rs.getString("Registeration_ID") + "   " +rs.getString("Patient_ID") + "   " + rs.getString("Patient_name") + "   " + rs.getString("Patient_age")
                        + "   " + rs.getString("Patient_gender") + "   " + rs.getString("Doctor_ID")+ "   " + rs.getString("Doctor_name")
                        + "   " + rs.getString("Pro_ID")+ "   " + rs.getString("Pro_name") + "   " + rs.getDouble("Price")+ "   " + rs.getString("pro_desc")
                        + "   " + rs.getString("Clinic_ID")+ "   " + rs.getString("Clinic_name"));
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchRegisteration()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            System.out.println("Enter the Patient_ID you want to search for: ");
            Scanner input=new Scanner(System.in);
            String statement = "SELECT * FROM Registeration where Patient_ID=" +input.next();
            ResultSet rs = s.executeQuery(statement);
            while(rs.next())

                System.out.println(rs.getString("Registeration_ID") + "   " + rs.getString("Patient_ID") + "   " + rs.getString("Patient_name") + "   " + rs.getString("Patient_age")
                        + "   " + rs.getString("Patient_gender") + "   " + rs.getString("Doctor_ID")+ "   " + rs.getString("Doctor_name")
                        + "   " + rs.getString("Pro_ID")+ "   " + rs.getString("Pro_name") + "   " + rs.getDouble("Price")+ "   " + rs.getString("pro_desc")
                        + "   " + rs.getString("Clinic_ID")+ "   " + rs.getString("Clinic_name"));
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteRegisteration()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement st = conn.createStatement();
            System.out.println("Enter the Patient_ID you want to delete: ");
            Scanner input=new Scanner(System.in);
            String statement = "delete from Registeration where Patient_ID="+input.next();
            int i=st.executeUpdate(statement);
            System.out.println("Row is deleted");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateRegisteration()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            System.out.println("Enter the Patient_ID you want to update: ");
            Scanner input=new Scanner(System.in);
            String d=input.next();
            System.out.println("Enter the Registeration ID");
            String r_Id = input.next();
            System.out.println("Enter the Patient ID");
            String pID = input.next();
            System.out.println("Enter the Patient Name");
            String pN = input.next();
            System.out.println("Enter the Patient Age");
            String pA = input.next();
            System.out.println("Enter the Patient Gender");
            String pg = input.next();
            System.out.println("Enter the Doctor ID");
            String dId = input.next();
            System.out.println("Enter the Doctor Name");
            String dN = input.next();
            System.out.println("Enter the Procedure ID");
            String prID = input.next();
            System.out.println("Enter the Procedure Name");
            String prN = input.next();
            System.out.println("Enter the Procedure Price");
            double pr = input.nextDouble();
            System.out.println("Enter the Procedure Description");
            String pro_d = input.next();
            System.out.println("Enter the Clinic ID");
            String cID = input.next();
            System.out.println("Enter the Clinic Name");
            String cN = input.next();
            s=conn.prepareStatement("update Registeration set Registeration_ID='"+r_Id+"', Patient_ID='"+pID+"', Patient_name='"+pN+"', Patient_age='"+pA+"', Patient_gender='"+pg+"', Doctor_ID='"+dId+"', Doctor_name='"+dN+"', Pro_ID='"+prID+"',Pro_name='"+prN+"', Price='"+pr+"', pro_desc='"+pro_d+"', Clinic_ID='"+cID+"', Clinic_name='"+cN+"' where Patient_ID="+d);
            s.executeUpdate();
            System.out.println("Row is updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPatient() {
        System.out.println("Enter the Patient ID");
        String pID = input.next();
        System.out.println("Enter the Patient Name");
        String pN = input.next();
        System.out.println("Enter the Patient Age");
        String pA = input.next();
        System.out.println("Enter the Patient Gender");
        String pg = input.next();
        patients.add(new Patient(pID, pN, pA, pg));
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            s=conn.prepareStatement("insert into Patient values('" + pID+ "','"+
                    pN+ "','" +pA + "','"+ pg +"')");
            s.execute();
            System.out.println("Row is added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        viewp();
    }

    public void viewp() {
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    public void viewPatient()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Patient");
            while(rs.next())

                System.out.println(rs.getString("Patient_ID") + "   " + rs.getString("Patient_name") + "   " + rs.getString("Patient_age")
                        + "   " + rs.getString("Patient_gender"));
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchPatient()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            System.out.println("Enter the Patient_ID you want to search for: ");
            Scanner input=new Scanner(System.in);
            String statement = "SELECT * FROM Patient where Patient_ID=" +input.next();
            ResultSet rs = s.executeQuery(statement);
            while(rs.next())

                System.out.println(rs.getString("Patient_ID") + "   " + rs.getString("Patient_name") + "   " + rs.getString("Patient_age")
                        + "   " + rs.getString("Patient_gender"));
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletePatient()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement st = conn.createStatement();
            System.out.println("Enter the Patient_ID you want to delete: ");
            Scanner input=new Scanner(System.in);
            String statement = "delete from Patient where Patient_ID="+input.next();
            int i=st.executeUpdate(statement);
            System.out.println("Row is deleted");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePatient()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            System.out.println("Enter the Patient_ID you want to update: ");
            Scanner input=new Scanner(System.in);
            String d=input.next();
            System.out.println("Enter the Patient ID");
            String pID = input.next();
            System.out.println("Enter the Patient Name");
            String pN = input.next();
            System.out.println("Enter the Patient Age");
            String pA = input.next();
            System.out.println("Enter the Patient Gender");
            String pg = input.next();
            s=conn.prepareStatement("update Patient set Patient_ID='"+pID+"', Patient_name='"+pN+"', Patient_age='"+pA+"', Patient_gender='"+pg+"' where Patient_ID="+d);
            s.executeUpdate();
            System.out.println("Row is updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addDoctor() {
        System.out.println("Enter the Doctor ID");
        String dId = input.next();
        System.out.println("Enter the Doctor Name");
        String dN = input.next();
        System.out.println("Enter the Clinic ID");
        String cID = input.next();
        System.out.println("Enter the Clinic Name");
        String cN = input.next();

        doctors.add(new Doctor(dId, dN, cID, cN));
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            s=conn.prepareStatement("insert into Doctor values('" + dId+ "','"+
                    dN+  "','"+ cID+ "','"+ cN+ "')");
            s.execute();
            System.out.println("Row is added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        viewd();
    }

    public void viewd() {
        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }
    public void viewDoctor()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Doctor");
            while(rs.next())

                System.out.println(rs.getString("Doctor_ID")+ "   " + rs.getString("Doctor_name")
                        + "   " + rs.getString("Clinic_ID")+ "   " + rs.getString("Clinic_name"));
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchDoctor()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            System.out.println("Enter the Doctor_ID you want to search for: ");
            Scanner input=new Scanner(System.in);
            String statement = "SELECT * FROM Doctor where Doctor_ID=" +input.next();
            ResultSet rs = s.executeQuery(statement);
            while(rs.next())
                System.out.println(rs.getString("Doctor_ID")+ "   " + rs.getString("Doctor_name")
                        + "   " + rs.getString("Clinic_ID")+ "   " + rs.getString("Clinic_name"));
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteDoctor()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement st = conn.createStatement();
            System.out.println("Enter the Doctor_ID you want to delete: ");
            Scanner input=new Scanner(System.in);
            String statement = "delete from Doctor where Doctor_ID="+input.next();
            int i=st.executeUpdate(statement);
            System.out.println("Row is deleted");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateDoctor()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            System.out.println("Enter the Doctor_ID you want to update: ");
            Scanner input=new Scanner(System.in);
            String d=input.next();
            System.out.println("Enter the Doctor ID");
            String dId = input.next();
            System.out.println("Enter the Doctor Name");
            String dN = input.next();
            System.out.println("Enter the Clinic ID");
            String cID = input.next();
            System.out.println("Enter the Clinic Name");
            String cN = input.next();
            s=conn.prepareStatement("update Doctor set Doctor_ID='"+dId+"', Doctor_name='"+dN+"' , Clinic_ID='"+cID+"', Clinic_name='"+cN+"' where Doctor_ID="+d);
            s.executeUpdate();
            System.out.println("Row is updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addClinic() {
        System.out.println("Enter the Clinic ID");
        String cID = input.next();
        System.out.println("Enter the Clinic Name");
        String cN = input.next();
        clinics.add(new Clinic(cID, cN));
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            s=conn.prepareStatement("insert into Clinic values('"+ cID+ "','"+ cN+"')");
            s.execute();
            System.out.println("Row is added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        viewc();
    }
    public void viewClinic()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Clinic");
            while(rs.next())

                System.out.println(rs.getString("Clinic_ID")+ "   " + rs.getString("Clinic_name"));
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void viewc() {
        for (Clinic c : clinics) {
            System.out.println(c);
        }
    }
    public void searchClinic() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            System.out.println("Enter the Clinic_ID you want to search for: ");
            Scanner input = new Scanner(System.in);
            String statement = "SELECT * FROM Clinic where Clinic_ID=" + input.next();
            ResultSet rs = s.executeQuery(statement);
            while (rs.next())

                System.out.println(rs.getString("Clinic_ID") + "   " + rs.getString("Clinic_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteClinic()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement st = conn.createStatement();
            System.out.println("Enter the Clinic_ID you want to delete: ");
            Scanner input=new Scanner(System.in);
            String statement = "delete from Clinic where Clinic_ID="+input.next();
            int i=st.executeUpdate(statement);
            System.out.println("Row is deleted");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateClinic()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            System.out.println("Enter the Clinic_ID you want to update: ");
            Scanner input=new Scanner(System.in);
            String d=input.next();
            System.out.println("Enter the Clinic ID");
            String cID = input.next();
            System.out.println("Enter the Clinic Name");
            String cN = input.next();
            s=conn.prepareStatement("update Clinic set Clinic_ID='"+cID+"', Clinic_name='"+cN+"' where Clinic_ID="+d);
            s.executeUpdate();
            System.out.println("Row is updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addProcedures() {


        System.out.println("Enter the Procedure ID");
        String prID = input.next();
        System.out.println("Enter the Procedure Name");
        String prN = input.next();
        System.out.println("Enter the Procedure Price");
        double pr = input.nextDouble();
        System.out.println("Enter the Procedure Description");
        String pro_d = input.next();
        procedure.add(new Procedures(prID, prN, pr, pro_d));
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            s=conn.prepareStatement("insert into Procedure values('"+ prID+ "','" +prN +
                    "',"+pr+ ",'"+ pro_d+ "')");
            s.execute();
            System.out.println("Row is added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        viewpr();
    }
    public void viewProcedure()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Procedure");
            while(rs.next())

                System.out.println(rs.getString("Pro_ID")+ "   " + rs.getString("Pro_name")
                        + "   " + rs.getDouble("Price")+ "   " + rs.getString("pro_desc"));
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void viewpr() {
        for (Procedures pr : procedure) {
            System.out.println("proId  Proname   ProPrice  Prodesc");
            System.out.println(pr);
        }
    }
    public void searchProcedure()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            System.out.println("Enter the Procedure_ID you want to search for: ");
            Scanner input=new Scanner(System.in);
            String statement = "SELECT * FROM Procedure where Pro_ID=" +input.next();
            ResultSet rs = s.executeQuery(statement);
            while(rs.next())

                System.out.println(rs.getString("Pro_ID")+ "   " +
                        rs.getString("Pro_name") + "   " + rs.getDouble("Price")+ "   " + rs.getString("pro_desc"));
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteProcedure()
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement st = conn.createStatement();
            System.out.println("Enter the Procedure_ID you want to delete: ");
            Scanner input=new Scanner(System.in);
            String statement = "delete from Procedure where Pro_ID="+input.next();
            int i=st.executeUpdate(statement);
            System.out.println("Row is deleted");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateProcedure()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            System.out.println("Enter the Procedure_ID you want to update: ");
            Scanner input=new Scanner(System.in);
            String d=input.next();
            System.out.println("Enter the Procedure ID");
            String prID = input.next();
            System.out.println("Enter the Procedure Name");
            String prN = input.next();
            System.out.println("Enter the Procedure Price");
            double pr = input.nextDouble();
            System.out.println("Enter the Procedure Description");
            String pro_d = input.next();

            s=conn.prepareStatement("update Procedure set Pro_ID='"+prID+"',Pro_name='"+prN+"', Price='"+pr+"', pro_desc='"+pro_d+"' where Pro_ID="+d);
            s.executeUpdate();
            System.out.println("Row is updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public DriverClass() {

        try {
            conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (true) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t Dental Information System\n");

            System.out.println("1 ===> Add Registeration's patient Record \t 6 ===> Add New Patient Record \t\t 11 ===> Add New Doctor Record \t\t 16 ===> Add New Procedure Record \t 21 ===> Add Clinic Record" );
            System.out.println("2 ===> View All Registeration's Record \t\t 7 ===> View Patient Record \t\t 12 ===> View Doctor Record \t\t 17 ===> View Procedure Record \t\t 22 ===> View Clinic Record");
            System.out.println("3 ===> Delete Registeration's Record \t\t 8 ===> Delete Patient Record \t\t 13 ===> Delete Doctor Record \t\t 18 ===> Delete Procedure Record \t 23 ===> Delete Clinic Record");
            System.out.println("4 ===> Search Registeration's Record \t\t 9 ===> Search Patient Record \t\t 14===> Search Doctor Record \t\t 19===> Search Procedure Record \t 24 ===> Search Clinic Record");
            System.out.println("5 ===> Update Registeration's Record  \t\t 10 ===> Update Patient Record \t\t 15 ===> Update Doctor Record \t\t 20 ===> Update Procedure Record \t 25 ===> Update Clinic Record");
            System.out.print("\n");
            int choice;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your choice");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    addRegisteration();
                    break;
                case 2:
                    viewRegisteration();
                    break;
                case 3:
                    deleteRegisteration();
                    break;
                case 4:
                    searchRegisteration();
                    break;
                case 5:
                    updateRegisteration();
                    break;
                case 6:
                    addPatient();
                    break;
                case 7:
                    viewPatient();
                    break;
                case 8:
                    deletePatient();
                    break;
                case 9:
                    searchPatient();
                    break;
                case 10:
                    updatePatient();
                    break;
                case 11:
                    addDoctor();
                    break;
                case 12:
                    viewDoctor();
                    break;
                case 13:
                    deleteDoctor();
                    break;
                case 14:
                    searchDoctor();
                    break;
                case 15:
                    updateDoctor();
                    break;
                case 16:
                    addProcedures();
                    break;
                case 17:
                    viewProcedure();
                    break;
                case 18:
                    deleteProcedure();
                    break;
                case 19:
                    searchProcedure();
                    break;
                case 20:
                    updateProcedure();
                    break;
                case 21:
                    addClinic();
                    break;
                case 22:
                    viewClinic();
                    break;
                case 23:
                    deleteClinic();
                    break;
                case 24:
                    searchClinic();
                    break;
                case 25:
                    updateClinic();
                    break;


            }


        }
    }


    public static void main(String[] args) {


     //   DriverClass d = new DriverClass();

    }
}