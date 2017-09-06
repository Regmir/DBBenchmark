/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Utility.UserStorage;
import model.dao.UsersstorageDAO;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class ExecuteLogin {
 
    public static final String LOGIN = "login";
    public static final String PASSWORD = "pas";
    public static final String PAGE = "index";

    @RequestMapping(value = "/Log",method=RequestMethod.POST)

    public String showMessage(@RequestParam String login, @RequestParam String pas,
             ModelMap model){
        if(UsersstorageDAO.PassCheck(login,pas)==true){
            UserStorage.setUser(login);  
            if (UserStorage.getLevel()==1) return "adminpage";
            return PAGE;
        }
        else return "loginerror";
    }
}
