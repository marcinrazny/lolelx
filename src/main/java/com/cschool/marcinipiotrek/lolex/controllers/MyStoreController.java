package com.cschool.marcinipiotrek.lolex.controllers;

import com.cschool.marcinipiotrek.lolex.entities.User;
import com.cschool.marcinipiotrek.lolex.services.AdvertisementService;
import com.cschool.marcinipiotrek.lolex.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MyStoreController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping("/mystore")
    public String getMyShop(Model model, Principal principal) {
        String email = principal.getName();
        User user = userService.findByEmail(email);

        model.addAttribute("adverts", advertisementService.findUserAdvetisement(user));
        return "views/mystore";

    }

}
