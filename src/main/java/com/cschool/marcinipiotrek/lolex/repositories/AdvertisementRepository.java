package com.cschool.marcinipiotrek.lolex.repositories;

import com.cschool.marcinipiotrek.lolex.entities.Advertisement;
import com.cschool.marcinipiotrek.lolex.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    List<Advertisement>findByUser(User user);

}
