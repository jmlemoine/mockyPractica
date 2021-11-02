package com.example.mockypractica.controller;

import com.example.mockypractica.model.API;
import com.example.mockypractica.model.Student;
import com.example.mockypractica.repository.APIRepository;
import com.example.mockypractica.repository.StudentRepository;
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
@RequestMapping("/api")
public class APIController {

    private final APIRepository apiRepository;

    @Autowired
    public APIController(APIRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(API api) {
        return "add-student";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("api", apiRepository.findAll());
        return "indexx";
    }

    @PostMapping("add")
    public String addStudent(@Valid API api, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }

        apiRepository.save(api);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        API api = apiRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("api", api);
        return "update-student";
    }

    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid API api, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            api.setId(id);
            return "update-student";
        }

        apiRepository.save(api);
        model.addAttribute("students", apiRepository.findAll());
        return "indexx";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        API api = apiRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        apiRepository.delete(api);
        model.addAttribute("students", apiRepository.findAll());
        return "indexx";
    }

}



