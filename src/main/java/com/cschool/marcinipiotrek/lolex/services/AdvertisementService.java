package com.cschool.marcinipiotrek.lolex.services;


import com.cschool.marcinipiotrek.lolex.entities.Advertisement;
import com.cschool.marcinipiotrek.lolex.entities.User;
import com.cschool.marcinipiotrek.lolex.repositories.AdvertisementRepository;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementService {

    @Autowired
    AdvertisementRepository advertisementRepository;


    public List<Advertisement> getAllAdvertisments() {
        return advertisementRepository.findAll();
    }

    public Optional<Advertisement> getOneAdvertismentById(Long id) {
        return advertisementRepository.findById(id);
    }

    public void addAdvertisment(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
    }

    public void updateAdvertisment(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
    }

    public void deleteAdvertisment(Long id) {
        advertisementRepository.deleteById(id);
    }


}
