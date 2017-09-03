/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Utility.QueryTime;
import java.sql.SQLException;
import java.util.Date;
import model.dao.DirectConnectionDAO;
import model.dao.HistoryDAO;
import model.dao.TesttableDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class ActionController {
 
    public static final String QUERY_TYPE = "query";
    public static final String QUERY_NUMBER = "number";
    public static final String CUSTOM = "custom";
    public static final String PAGE = "result";

    @RequestMapping(value = "/Action",method=RequestMethod.POST)

    public String showMessage(@RequestParam String query, @RequestParam Integer number,
            @RequestParam String custom, ModelMap model){
        QueryTime qt=new QueryTime();
        String qtype="None";
        String error="-";
        if ((number<=0)||(number>=200001)) {
            qt.setTotal(0);     
            error="Number should be between 0 and 200000";
        } else
        if(query.compareTo("Create")==0){
            TesttableDAO.Insert(number, qt);
            qtype="Create";
            custom="-";
        } else
        if(query.compareTo("Delete")==0){
            TesttableDAO.Delete(number, qt);
            qtype="Delete";
            custom="-";
        } else
        if(query.compareTo("Read")==0){
            TesttableDAO.SelectWithTiming(number, qt);
            qtype="Read";
            custom="-";
        } else
        if(query.compareTo("Update")==0){
            TesttableDAO.Update(number, qt);
            qtype="Update";
            custom="-";
        }
        if(query.compareTo("Custom")==0){
            try {
                DirectConnectionDAO.Execute(custom,qt);
            } catch (ClassNotFoundException ex) {
                custom="Incorrect Query";
                error="Incorrect Query";
            } catch (SQLException ex) {
                custom="Incorrect Query";
                error="Incorrect Query";
            }
            qtype="Custom";
        }
        String user="User";
        Date date = new Date();
        if(qt.getTotal()!=0)
        HistoryDAO.Insert(qtype, number, qt.getAverage()/1000000, 
                qt.getMin()/1000000, qt.getMax()/1000000,
                qt.getTotal()/1000000, date, custom, user);
        model.addAttribute("Avg",qt.getAverage()/1000000);
        model.addAttribute("Max",qt.getMax()/1000000);
        model.addAttribute("Min",qt.getMin()/1000000);
        model.addAttribute("Total",qt.getTotal()/1000000);
        model.addAttribute(QUERY_TYPE, query);
        model.addAttribute(QUERY_NUMBER, number); 
        model.addAttribute("error", error);
        return PAGE;
    }
}
