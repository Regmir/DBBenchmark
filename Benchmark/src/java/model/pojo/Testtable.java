package model.pojo;
// Generated 30.07.2017 14:39:43 by Hibernate Tools 4.3.1



/**
 * Testtable generated by hbm2java
 */
public class Testtable  implements java.io.Serializable {

     private int id;
     private String randomdata;

    public Testtable() {
    }

	
    public Testtable(int id) {
        this.id = id;
    }
    public Testtable(int id, String randomdata) {
       this.id = id;
       this.randomdata = randomdata;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getRandomdata() {
        return this.randomdata;
    }
    
    public void setRandomdata(String randomdata) {
        this.randomdata = randomdata;
    }




}


