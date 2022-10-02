package com.springjwt.repository;

import com.springjwt.models.NewJoiner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewJoinerRepository extends JpaRepository<NewJoiner, Long> {

    List<NewJoiner> getAll();
}
