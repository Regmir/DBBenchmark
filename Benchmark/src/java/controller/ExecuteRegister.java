/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import model.dao.UsersstorageDAO;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class ExecuteRegister {
 
    public static final String LOGIN = "login";
    public static final String PASSWORD = "pas";
    public static final String EMAIL = "email";
    public static final String PAGE = "loginscreen";

    @RequestMapping(value = "/Reg",method=RequestMethod.POST)

    public String showMessage(@RequestParam String login, @RequestParam String pas,
            @RequestParam String email, ModelMap model){
        if(UsersstorageDAO.LogExisting(login)==false)
        {
            String HashedPas;
            HashedPas = DigestUtils.md5Hex(pas);
            UsersstorageDAO.Insert(login, HashedPas, email, 0);
            return PAGE;
        }
        else return "registererror";
    }
}
