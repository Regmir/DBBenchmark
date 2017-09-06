/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Utility.UserStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class AdminCheck {
 
    public static final String PAGE = "index";

    @RequestMapping(value = "/index.htm")

    public String showMessage(ModelMap model){
        if(UserStorage.getLevel()==1){
            return "adminpage";
        }
        else return PAGE;
    }
}
