/**
 * Created by Eiman on 12/16/2020.
 */
public class Procedures {
    private String proId;
    private String pro_name;
    private double price;
    private String pro_desc;

    public Procedures(String proId, String pro_name, double price, String pro_desc) {
        this.proId = proId;
        this.pro_name = pro_name;
        this.price = price;
        this.pro_desc = pro_desc;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPro_desc() {
        return pro_desc;
    }

    public void setPro_desc(String pro_desc) {
        this.pro_desc = pro_desc;
    }
    public String toString()
    {
        String proc=proId+"\n"+pro_name+"\n"+price+"\n"+pro_desc;
        return proc;
    }

}
