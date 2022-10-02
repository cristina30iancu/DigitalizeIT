package com.springjwt.repository;

import com.springjwt.models.NewJoiner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewJoinerRepository extends JpaRepository<NewJoiner, Long> {

}
