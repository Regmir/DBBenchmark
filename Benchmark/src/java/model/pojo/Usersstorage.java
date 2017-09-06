/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

/**
 *
 * @author Acer
 */
public class Usersstorage implements java.io.Serializable {
    private String DBUserName;
    private int ID;
    private String DBUserPas;
    private String DBUserEmail;
    private int AccessLevel;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String DBUserName() {
        return DBUserName;
    }

    public void DBUserName(String DBUserName) {
        this.DBUserName = DBUserName;
    }

    public String getDBUserName() {
        return DBUserName;
    }

    public void setDBUserName(String DBUserName) {
        this.DBUserName = DBUserName;
    }

    public String getDBUserPas() {
        return DBUserPas;
    }

    public void setDBUserPas(String DBUserPas) {
        this.DBUserPas = DBUserPas;
    }

    public String getDBUserEmail() {
        return DBUserEmail;
    }

    public void setDBUserEmail(String DBUserEmail) {
        this.DBUserEmail = DBUserEmail;
    }

    public int getAccessLevel() {
        return AccessLevel;
    }

    public void setAccessLevel(int AccessLevel) {
        this.AccessLevel = AccessLevel;
    }
    
}
