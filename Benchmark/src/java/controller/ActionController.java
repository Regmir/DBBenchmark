/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Utility.QueryTime;
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
        if(query.compareTo("Create")==0)
            TesttableDAO.Insert(number, qt);
        if(query.compareTo("Delete")==0)
            TesttableDAO.Delete(number, qt);
        model.addAttribute("Avg",qt.getAverage());
        model.addAttribute("Max",qt.getMax());
        model.addAttribute("Min",qt.getMin());
        model.addAttribute("Total",qt.getTotal());
        model.addAttribute(QUERY_TYPE, query);
        model.addAttribute(QUERY_NUMBER, number);       
        return PAGE;
    }
}
