package com.cschool.marcinipiotrek.lolex.controllers;

import com.cschool.marcinipiotrek.lolex.entities.User;
import com.cschool.marcinipiotrek.lolex.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EditUserController {
    @Autowired
    private UserService userService;

    @GetMapping("/edit_profile/{email}")
    public String showUpdatePage(@PathVariable("email") String email, Model model) {
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);
        return "views/edit_profile";

    }

    @PostMapping("/update/{email}")
    public String updateUser(@PathVariable("email") String email, @Valid User user, BindingResult result, Model model) {
        System.out.println("ZMIENIONO DANE");
        if (result.hasErrors()) {
            user.setEmail(email);
            System.out.println("WYGIBALO JAK JASNY CIUL");
            return "views/edit_profile";
        }

        user.setRoles(userService.findByEmail(email).getRoles());
        userService.save(user);
        model.addAttribute("users", userService.findAll());
        return "redirect:/profile";
    }


}
