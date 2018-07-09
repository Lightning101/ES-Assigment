package Database.Entities;
// Generated Jul 10, 2018 2:34:36 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Members generated by hbm2java
 */
public class Members  implements java.io.Serializable {


     private int id;
     private String name;
     private String address;
     private Date dob;
     private Date dor;
     private float balance;
     private Set userses = new HashSet(0);

    public Members() {
    }

	
    public Members(int id, float balance) {
        this.id = id;
        this.balance = balance;
    }
    public Members(int id, String name, String address, Date dob, Date dor, float balance, Set userses) {
       this.id = id;
       this.name = name;
       this.address = address;
       this.dob = dob;
       this.dor = dor;
       this.balance = balance;
       this.userses = userses;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public Date getDor() {
        return this.dor;
    }
    
    public void setDor(Date dor) {
        this.dor = dor;
    }
    public float getBalance() {
        return this.balance;
    }
    
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public Set getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set userses) {
        this.userses = userses;
    }




}


