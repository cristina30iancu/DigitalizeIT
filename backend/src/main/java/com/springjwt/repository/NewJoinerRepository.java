package com.springjwt.repository;

import com.springjwt.models.JwtUser;
import com.springjwt.models.NewJoiner;
import io.jsonwebtoken.Jwt;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface NewJoinerRepository extends JpaRepository<NewJoiner, Integer> {
    NewJoiner findAllByFirstNameAndLastName(@NotNull String firstName, @NotNull String lastName);
    List<NewJoiner> findAllByFirstName(@NotNull String firstName);
    List<NewJoiner> findAllByLastName(@NotNull String lastName);
    List<NewJoiner> findNewJoinersByProject(@NotNull String project);
    List<NewJoiner> findAllByOrderByStartDateAsc();
    NewJoiner findById(Long id);



}
