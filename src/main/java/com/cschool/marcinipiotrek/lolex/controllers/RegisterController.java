package com.cschool.marcinipiotrek.lolex.controllers;


import com.cschool.marcinipiotrek.lolex.entities.User;
import com.cschool.marcinipiotrek.lolex.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
@Autowired
    private UserService userService;

@GetMapping("/register")
    public String getRegister(Model model){
    model.addAttribute("user", new User());
    return "views/register";
}

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("error");
            return "views/register";

        }
        if (userService.isUserPresent(user.getEmail())) {
            model.addAttribute("isExist", true);
            System.out.println(user);
            System.out.println("isExist");
            return "views/register";

        }
        userService.createRegularUser(user);
        return "profile";

    }


}
