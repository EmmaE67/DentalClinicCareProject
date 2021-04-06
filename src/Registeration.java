/**
 * Created by Eiman on 12/16/2020.
 */
public class Registeration {
    private Patient pafile;
    private Doctor dfile;
    private Procedures pfile;
    private String r_Id;

    public Registeration (String r_Id, String pID, String pN, String pA, String pg,
                          String dId, String dN,
                          String prID, String prN, double pr, String pro_d,
                          String cID, String cN)
    {
        this.r_Id = r_Id;
        pafile=new Patient(pID,pN,pA,pg);
        dfile=new Doctor(dId,dN,cID,cN);
        pfile=new Procedures(prID,prN,pr,pro_d);

    }
    public String toString()
    {
        String r="Registeration Detalis\n"+r_Id+"\n"+pafile.toString()+"\n"+dfile.toString()
                +"\n"+pfile.toString();
        return r;
    }

}
