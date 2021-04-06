/**
 * Created by Eiman on 12/16/2020.
 */
public class Clinic {
    private String clinicID;
    private String clinic_name;

    public Clinic(String clinicID, String clinic_name) {
        this.clinicID = clinicID;
        this.clinic_name = clinic_name;
    }

    public String getClinicID() {
        return clinicID;
    }

    public void setClinicID(String clinicID) {
        this.clinicID = clinicID;
    }

    public String getClinic_name() {
        return clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }
    public String toString()
    {
        String cl=clinicID+"\n"+clinic_name;
        return cl;
    }
}
