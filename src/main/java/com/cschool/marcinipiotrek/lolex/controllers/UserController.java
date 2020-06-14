package com.cschool.marcinipiotrek.lolex.controllers;

import com.cschool.marcinipiotrek.lolex.entities.Advertisement;
import com.cschool.marcinipiotrek.lolex.entities.User;
import com.cschool.marcinipiotrek.lolex.services.AdvertisementService;
import com.cschool.marcinipiotrek.lolex.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdvertisementService advertisementService;


    @GetMapping("/user_list")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "views/user_list";
    }

    @GetMapping("/profile")
    public String getUser(Model model, Principal principal) {
        String email = principal.getName();
        model.addAttribute("user", userService.findByEmail(email));
        return "views/profile";
    }

    @PostMapping("/delete")
    public String delete(@Valid User user, BindingResult bindingResult, HttpSession httpSession) {

        String email = (String) httpSession.getAttribute("email");
        userService.delete(user);
        return "redirect:/user_list";
    }
}
