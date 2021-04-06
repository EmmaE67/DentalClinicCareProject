/**
 * Created by Eiman on 12/16/2020.
 */
public class Patient extends Person {
    private String patientAge;
    private String patientgender;

    public Patient(String personId, String personName,String patientAge, String patientgender) {
        super(personId, personName);
        this.patientgender = patientgender;
        this.patientAge=patientAge;

    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientgender() {
        return patientgender;
    }

    public void setPatientgender(String patientgender) {
        this.patientgender = patientgender;
    }

    public String toString()
    {
        String pa=super.toString()+"\n"+patientAge+"\n"+patientgender;
        return pa;
    }
}
