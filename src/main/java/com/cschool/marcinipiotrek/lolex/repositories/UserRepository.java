package com.cschool.marcinipiotrek.lolex.repositories;

import com.cschool.marcinipiotrek.lolex.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User>findByFirstName(String name);
    User findByEmail(String email);

}
