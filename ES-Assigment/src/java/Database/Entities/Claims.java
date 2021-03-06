package Database.Entities;
// Generated Jul 10, 2018 2:34:36 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Claims generated by hbm2java
 */
public class Claims  implements java.io.Serializable {


     private int id;
     private String memId;
     private Date date;
     private String rationale;
     private String status;
     private float amount;

    public Claims() {
    }

    public Claims(int id, String memId, Date date, String rationale, String status, float amount) {
       this.id = id;
       this.memId = memId;
       this.date = date;
       this.rationale = rationale;
       this.status = status;
       this.amount = amount;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getMemId() {
        return this.memId;
    }
    
    public void setMemId(String memId) {
        this.memId = memId;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getRationale() {
        return this.rationale;
    }
    
    public void setRationale(String rationale) {
        this.rationale = rationale;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public float getAmount() {
        return this.amount;
    }
    
    public void setAmount(float amount) {
        this.amount = amount;
    }




}


