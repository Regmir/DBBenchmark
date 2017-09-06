/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.UsersstorageDAO;
import model.pojo.Usersstorage;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Acer
 */
public class UsersController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("users");
        List<Usersstorage> list = UsersstorageDAO.Select();
        //TesttableDAO.Update((short)2, "RD");
        //TesttableDAO.Insert();
        //TesttableDAO.Delete((short)19);
        mv.addObject("data",list);
        return mv;
    }
    
}
