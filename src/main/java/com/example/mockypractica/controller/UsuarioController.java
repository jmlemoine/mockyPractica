package com.example.mockypractica.controller;

import com.example.mockypractica.model.Usuario;
import com.example.mockypractica.repository.UsuarioRepository;
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
@RequestMapping("/users")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Usuario usuario) {
        return "add-student";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("users", usuarioRepository.findAll());
        return "indexx";
    }

    @PostMapping("add")
    public String addUser(@Valid Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }
        usuarioRepository.save(usuario);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id: "+id));
        model.addAttribute("student", usuario);
        return "update-student";
    }

    @PostMapping("update/{id}")
    public String updateUsuario(@PathVariable("id") long id, @Valid Usuario usuario, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            usuario.setId(id);
            return "update-student";
        }
        usuarioRepository.save(usuario);
        model.addAttribute("students", usuarioRepository.findAll());
        return "indexx";
    }

    @GetMapping("delete/{id}")
    public String deleteUsuario(@PathVariable("id") long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id: "+id));
        usuarioRepository.delete(usuario);
        model.addAttribute("students", usuarioRepository.findAll());
        return "indexx";
    }

}
