package com.example.mockypractica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AppController {

    /*@GetMapping("/")
    public String getWelcome() {
        //return "index";
        return "<h1>Klk con Klk</h1>";
        //return "redirect:login";
    }*/

    @GetMapping("/user")
    public String getUser() {
        //return "index";
        return "<h1>Klk con User</h1>";
        //return "redirect:login";
    }

    /*@GetMapping("/admin")
    public String getAdmin() {
        //return "<h1>Klk con Admin</h1>";
        return "klk";
    }*/

    @RequestMapping(value = /*"/admin"*/"/", method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView model = new ModelAndView();
        model.setViewName("klk");
        return model;
    }

}
