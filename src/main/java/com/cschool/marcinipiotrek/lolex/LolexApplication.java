package com.cschool.marcinipiotrek.lolex;

import com.cschool.marcinipiotrek.lolex.entities.Advertisement;
import com.cschool.marcinipiotrek.lolex.entities.User;
import com.cschool.marcinipiotrek.lolex.services.AdvertisementService;
import com.cschool.marcinipiotrek.lolex.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.util.calendar.BaseCalendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class LolexApplication implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    AdvertisementService advertisementService;

    public static void main(String[] args) {
        SpringApplication.run(LolexApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {

        Date date = new Date();
        List<Advertisement> advertisements = new ArrayList<>();

        User user1 = new User("reguarUser@wp.pl", "regularUser", "kowalski", "aaaaa");
        userService.createRegularUser(user1);

        User user2 = new User("reguarUser2@wp.pl", "regularUser2", "nowak", "bbbbb");
        userService.createRegularUser(user2);

        User user3 = new User("reguarUser3@wp.pl", "regularUser3", "janicki", "cccc");
        userService.createRegularUser(user3);


        User newAdmin = new User("admin@wp.pl", "admin", "janienicki", "dddd");
        userService.createAdmin(newAdmin);

        Advertisement advertisement = new Advertisement("samochód", "motoryzacja", 222,"01-02-2020","10-05-2020");
        System.out.println(advertisement.toString());

        advertisementService.addAdvertisement(advertisement,user1);

    }

}
