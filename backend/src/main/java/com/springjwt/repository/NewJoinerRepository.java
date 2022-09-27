package com.springjwt.repository;

import com.springjwt.models.NewJoiner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewJoinerRepository extends JpaRepository<NewJoiner, Integer> {
}
