package com.dbcs.digitalizeit.repository;//package com.bezkoder.springjwt.repository;

import java.util.Optional;

import com.dbcs.digitalizeit.models.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbcs.digitalizeit.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(EmployeeRole name);
}
