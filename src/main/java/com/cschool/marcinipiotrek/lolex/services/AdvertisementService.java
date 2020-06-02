package com.cschool.marcinipiotrek.lolex.services;


import com.cschool.marcinipiotrek.lolex.entities.Advertisement;
import com.cschool.marcinipiotrek.lolex.entities.User;
import com.cschool.marcinipiotrek.lolex.repositories.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdvertisementService {

    @Autowired
    AdvertisementRepository advertisementRepository;

    public void addAdvertisement(Advertisement advertisement, User user) {
        advertisement.setUser(user);
        advertisementRepository.save(advertisement);
    }

    public List<Advertisement> findUserAdvetisement(User user) {
        return advertisementRepository.findByUser(user);
    }

}
