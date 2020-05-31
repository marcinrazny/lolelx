package com.cschool.marcinipiotrek.lolex.controllers;

import com.cschool.marcinipiotrek.lolex.entities.Advertisement;
import com.cschool.marcinipiotrek.lolex.services.AdvertisementService;
import com.cschool.marcinipiotrek.lolex.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;
    @Autowired
    private UserService userService;

    @GetMapping("/advertisement_add")
    public String getAdvertisement(String email, Model model, HttpSession httpSession) {
        httpSession.setAttribute("email", email);
        model.addAttribute("advertisement", new Advertisement());
        return "views/advertisement_add";
    }

    @PostMapping("/advertisement_add")
    public String addAdvertisement(@Valid Advertisement advertisement, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "views/advertisement_add";
        }
        String email = (String) httpSession.getAttribute("email");
        advertisementService.addAdvertisement(advertisement, userService.findByEmail(email));
        return "redirect:/users";
    }
}
