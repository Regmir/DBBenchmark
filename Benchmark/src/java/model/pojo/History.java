/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.Date;

/**
 *
 * @author Acer
 */
public class History implements java.io.Serializable {
    private int ID;
    private String Type;
    private int Number;
    private double Avg;
    private double Min;
    private double Max;
    private double Total;
    private Date Date;
    private String CustomQuery;
    private String User;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public double getAvg() {
        return Avg;
    }

    public void setAvg(double Avg) {
        this.Avg = Avg;
    }

    public double getMin() {
        return Min;
    }

    public void setMin(double Min) {
        this.Min = Min;
    }

    public double getMax() {
        return Max;
    }

    public void setMax(double Max) {
        this.Max = Max;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getCustomQuery() {
        return CustomQuery;
    }

    public void setCustomQuery(String CustomQuery) {
        this.CustomQuery = CustomQuery;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }
    
}
