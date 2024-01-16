package com.spring_boot.demo.controller;

import com.spring_boot.demo.model.User;
import com.spring_boot.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private final UserService userService;
    private final String SUCCESS = "redirect:/";

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "cars";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String processEditUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.update(user);
        return SUCCESS;
    }


    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        userService.update(user);
        return SUCCESS;
    }


    @GetMapping(value = "/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }
    @PostMapping(value = "/update")
    public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String surname, @RequestParam String email) {
        User user = new User(name, surname, email);
        user.setId(id);
        userService.update(user);
        return SUCCESS;
    }

    @PostMapping(value = "/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return SUCCESS;
    }

}
