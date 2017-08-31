/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Utility.QueryTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Calendar;
import java.util.Date;
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
    public static final String PAGE = "result";

    @RequestMapping(value = "/Action",method=RequestMethod.POST)

    public String showMessage(@RequestParam String query, @RequestParam Integer number, ModelMap model) {
        QueryTime qt=new QueryTime();
        String qtype="None";
        if ((number<=0)||(number>=200001)) {
            qt.setTotal(0);          
        } else
        if(query.compareTo("Create")==0){
            TesttableDAO.Insert(number, qt);
            qtype="Create";
        } else
        if(query.compareTo("Delete")==0){
            TesttableDAO.Delete(number, qt);
            qtype="Delete";
        } else
        if(query.compareTo("Read")==0){
            TesttableDAO.SelectWithTiming(number, qt);
            qtype="Read";
        } else
        if(query.compareTo("Update")==0){
            TesttableDAO.Update(number, qt);
            qtype="Update";
        }
        String user="User";
        Date date = new Date();
        if(qt.getTotal()!=0)
        HistoryDAO.Insert(qtype, number, qt.getAverage()/1000000, 
                qt.getMin()/1000000, qt.getMax()/1000000,
                qt.getTotal()/1000000, date, "-", user);
        model.addAttribute("Avg",qt.getAverage()/1000000);
        model.addAttribute("Max",qt.getMax()/1000000);
        model.addAttribute("Min",qt.getMin()/1000000);
        model.addAttribute("Total",qt.getTotal()/1000000);
        model.addAttribute(QUERY_TYPE, query);
        model.addAttribute(QUERY_NUMBER, number);       
        return PAGE;
    }
}
