package com.cschool.marcinipiotrek.lolex.repositories;

import com.cschool.marcinipiotrek.lolex.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
