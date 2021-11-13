package com.example.mockypractica.controller;

import com.example.mockypractica.model.Mock;
//import com.example.mockypractica.repository.MockRepository;
import com.example.mockypractica.repository.*;//MockRepository;
import com.example.mockypractica.model.*;
import com.example.mockypractica.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/mocks/")
public class MockController {

    private final MockRepository mockRepository;

    @Autowired
    public MockController(MockRepository mockRepository) {
        this.mockRepository = mockRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Mock mock) {
        return "add-mock";
    }

    @GetMapping("signupUser")
    public String showSignUpFormUser(Mock mock) {
        return "add-mockUser";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("mocks", mockRepository.findAll());
        return "klk";
    }

    @GetMapping("listUser")
    public String showUpdateFormUser(Model model) {
        model.addAttribute("mocks", mockRepository.findAll());
        return "klkUser";
    }

    @PostMapping("add")
    public String addMock(@Valid Mock mock, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-mock";
        }
        mockRepository.save(mock);
        return "redirect:list";
    }

    @PostMapping("addUser")
    public String addMockUser(@Valid Mock mock, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-mockUser";
        }
        mockRepository.save(mock);
        return "redirect:listUser";
    }

    /*@GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Mock mock = mockRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid mock Id: " + id));
            model.addAttribute("mock", mock);
            return "update-mock";
    }*/

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Mock mock = mockRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute(/*"mock"*/"mock", mock);
        return "update-mock";

        /*
        ModelAndView model = new ModelAndView();
        model.setViewName("klk");
        return model;
        */
    }

    @PostMapping("update/{id}")
    public String updateMock(@PathVariable("id"/*"idMock"*/) long id, @Valid Mock mock, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            mock.setId(id);//setIdMock(id);
            return "update-mock";
        }
        mockRepository.save(mock);
        model.addAttribute("mocks", mockRepository.findAll());
        return "klk";
    }

    @GetMapping("delete/{id}")
    public String deleteMock(@PathVariable("id"/*"idMock"*/) long id, Model model) {
        Mock mock = mockRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid mock Id:" + id));
        mockRepository.delete(mock);
        model.addAttribute("mocks", mockRepository.findAll());
        return "klk";
    }

}
