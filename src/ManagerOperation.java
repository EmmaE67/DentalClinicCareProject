import java.sql.*;
import java.util.Scanner;

/**
 * Created by Eiman on 12/17/2020.
 */
public class ManagerOperation {

    Connection conn;
    LinkedQueue<Registeration> registerations = new LinkedQueue<>();
    Scanner input = new Scanner(System.in);
    LinkedQueue<Patient> patients = new LinkedQueue<>();
    LinkedQueue<Doctor> doctors = new LinkedQueue<>();
    LinkedQueue<Clinic> clinics = new LinkedQueue<>();
    LinkedQueue<Procedures> procedure = new LinkedQueue<>();

    /**
     * Add a registeration
     */
    public void addRegist(String r_Id, String pID, String pN, String pA, String pg,
                          String dId, String dN,
                          String prID, String prN, double pr, String pro_d,
                          String cID, String cN) {

        registerations.enqueue((new Registeration(r_Id, pID, pN, pA, pg, dId, dN, prID, prN, pr, pro_d, cID, cN)));
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            s = conn.prepareStatement("insert into Registeration (Registeration_ID,Patient_ID,Patient_name,Patient_age,Patient_gender,Doctor_ID" +
                    ",Doctor_name,Pro_ID,Pro_name,Price,pro_desc,Clinic_ID,Clinic_name) values('" + r_Id + "','" + pID + "','" +
                    pN + "','" + pA + "','" + pg + "','" +
                    dId + "','" + dN + "','" + prID + "','" + prN +
                    "'," + pr + ",'" + pro_d + "','" + cID + "','" + cN + "')");
            System.out.println("'" + r_Id + "'\n,'" + pID + "'\n,'" +
                    pN + "'\n,'" + pA + "'\n,'" + pg + "'\n,'" +
                    dId + "'\n,'" + dN + "'\n,'" + prID + "'\n,'" + prN +
                    "',\n" + pr + ",'\n" + pro_d + "'\n,'" + cID + "'\n,'" + cN + "\n')");
            s.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // view();
    }

    /**
     * Search for a registeration
     */
    public void searchRegisteration(String patientID) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            String statement = "SELECT * FROM Registeration where Patient_ID=" + patientID;
            ResultSet rs = s.executeQuery(statement);
            while (rs.next())

                System.out.println(rs.getString("Registeration_ID") + "   " + rs.getString("Patient_ID") + "   " + rs.getString("Patient_name") + "   " + rs.getString("Patient_age")
                        + "   " + rs.getString("Patient_gender") + "   " + rs.getString("Doctor_ID") + "   " + rs.getString("Doctor_name")
                        + "   " + rs.getString("Pro_ID") + "   " + rs.getString("Pro_name") + "   " + rs.getDouble("Price") + "   " + rs.getString("pro_desc")
                        + "   " + rs.getString("Clinic_ID") + "   " + rs.getString("Clinic_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a registeration
     */
    public void deleteRegisteration(Registeration patientID) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement st = conn.createStatement();

            patientID = registerations.dequeue();
            String statement = "delete from Registeration where Patient_ID=" + patientID;
            int i = st.executeUpdate(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * add a Doctor
     */

    public void addDoc(String dId, String dN, String cID, String cN) {

        doctors.enqueue((new Doctor(dId, dN, cID, cN)));
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            s = conn.prepareStatement("insert into Doctor (Doctor_ID" +
                    ",Doctor_name,Clinic_ID,Clinic_name) values('" +
                    dId + "','" + dN + "','" + cID + "','" + cN + "')");
            System.out.println("'" + dId + "'\n,'" + dN + "'\n,'" + cID + "'\n,'" + cN + "\n')");
            s.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * search for a Doctor
     */
    public void searchDoctor(String DoctorId) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            //  System.out.println("Enter the Patient_ID you want to search for: ");
            //  Scanner input=new Scanner(System.in);
            String statement = "SELECT * FROM Doctor where Doctor_ID=" + DoctorId;
            ResultSet rs = s.executeQuery(statement);
            while (rs.next())

                System.out.println(rs.getString("Doctor_ID") + "   " + rs.getString("Doctor_name")
                        + "   " + rs.getString("Clinic_ID") + "   " + rs.getString("Clinic_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Delete a Doctor
     */
    public void deleteDoctor(Doctor DoctorId) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement st = conn.createStatement();
            DoctorId = doctors.dequeue();
            String statement = "delete from Doctor where Doctor_ID=" + DoctorId;
            int i = st.executeUpdate(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * add a Patient
     */
    public void addPatient(String pID, String pN, String pA, String pg) {

        patients.enqueue((new Patient( pID, pN, pA, pg)));
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            s = conn.prepareStatement("insert into Patient(Patient_ID,Patient_name,Patient_age,Patient_gender) values('" + pID + "','" +
                    pN + "','" + pA + "','" + pg  + "')");
            System.out.println("'" + pID + "'\n,'" +
                    pN + "'\n,'" + pA + "'\n,'" + pg  + "\n')");
            s.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // view();
    }

    /**
     * Search for a Patient
     */
    public void searchPatient(String patientID) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            String statement = "SELECT * FROM Patient where Patient_ID=" + patientID;
            ResultSet rs = s.executeQuery(statement);
            while (rs.next())

                System.out.println(rs.getString("Patient_ID") + "   " + rs.getString("Patient_name") + "   " + rs.getString("Patient_age")
                        + "   " + rs.getString("Patient_gender"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Delete a Patient
     */

    public void deletePatient(Patient patientID) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement st = conn.createStatement();

            patientID = patients.dequeue();
            String statement = "delete from Patient where Patient_ID=" + patientID;
            int i = st.executeUpdate(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * add a Procedure
     */
    public void addProcedure(String prID, String prN, double pr, String pro_d) {

        procedure.enqueue((new Procedures(prID, prN, pr, pro_d)));
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            s = conn.prepareStatement("insert into Procedure (Pro_ID,Pro_name,Price,pro_desc) values('" + prID + "','" + prN +
                    "'," + pr + ",'" + pro_d + "')");
            System.out.println("'"  + prID + "'\n,'" + prN +
                    "',\n" + pr + ",'\n" + pro_d + "\n')");
            s.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // view();
    }

    /**
     * Search for a Procedure
     */
    public void searchProcedure(String proId) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            String statement = "SELECT * FROM Procedure where Pro_ID=" + proId;
            ResultSet rs = s.executeQuery(statement);
            while (rs.next())

                System.out.println(rs.getString("Pro_ID") + "   " + rs.getString("Pro_name") + "   " +
                        rs.getDouble("Price") + "   " + rs.getString("pro_desc"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a Procedure
     */
    public void deleteProcedure(Procedures proId) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement st = conn.createStatement();

            proId = procedure.dequeue();
            String statement = "delete from Procedure where Patient_ID=" + proId;
            int i = st.executeUpdate(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * add a Clinic
     */
    public void addClinic(String cID, String cN) {

        clinics.enqueue((new Clinic(cID, cN)));
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            PreparedStatement s;
            s = conn.prepareStatement("insert into Clinic (Clinic_ID,Clinic_name) values('" + cID + "'\n,'" + cN + "\n')");
            s.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // view();
    }

    /**
     * Search for a Clinic
     */
    public void searchClinic(String clinicID) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement s = conn.createStatement();
            String statement = "SELECT * FROM Clinic where Clinic_ID=" + clinicID;
            ResultSet rs = s.executeQuery(statement);
            while (rs.next())

                System.out.println(rs.getString("Clinic_ID") + "   " + rs.getString("Clinic_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a Clinic
     */
    public void deleteClinic(Registeration clinicID) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Databasejava\\Stu.accdb");
            Statement st = conn.createStatement();

            clinicID = registerations.dequeue();
            String statement = "delete from Clinic where Clinic_ID=" + clinicID;
            int i = st.executeUpdate(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

