package com.springjwt.repository;

import com.springjwt.models.JwtUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<JwtUser, Long> {

    Optional<JwtUser> findUserByUsername(String username);
    Optional<JwtUser> findUserByEmail(String email);

}