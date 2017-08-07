/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateController {

@RequestMapping(value = "/Benchmark/test.form",method = RequestMethod.GET)
public String test(@RequestParam("name") String param,Model model){
    model.addAttribute("name",param);
    return "index";
}
}
