/**
 * Created by Eiman on 3/25/2021.
 */
public class Doctor extends Person  {

        private String DoctorName;
        private String DoctorId;
        private Clinic cfile;

        public Doctor(String personId, String personName, String cID, String cN) {

            super(personId, personName);
            cfile=new Clinic(cID,cN);
        }

        public String getDoctorName() {
            return DoctorName;
        }

        public void setDoctorName(String doctorName) {
            DoctorName = doctorName;
        }

        public String getDoctorId() {
            return DoctorId;
        }

        public void setDoctorId(String doctorId) {
            DoctorId = doctorId;
        }



        public String toString() {
            String d = super.toString()+"\n"+cfile.toString();
            return d;
        }
    }


