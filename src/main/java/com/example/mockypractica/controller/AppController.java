package com.example.mockypractica.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("/main/")
public class AppController {

    @GetMapping("/")
    public String getWelcome() {
        //return "index";
        return "<h1>Klk con Klk</h1>";
        //return "redirect:login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView model = new ModelAndView();
        model.setViewName("klk");
        return model;
    }

    /*@GetMapping("/admin")
    public String getAdmin() {
        return "<h1>Klk con Admin</h1>";
        //return "index";
    }*/

    @GetMapping("/user")
    public String getUser() {
        return "<h1>Klk con User</h1>";
    }

}
