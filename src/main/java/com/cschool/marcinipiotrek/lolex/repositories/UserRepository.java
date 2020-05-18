package com.cschool.marcinipiotrek.lolex.repositories;

import com.cschool.marcinipiotrek.lolex.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long> {
}
