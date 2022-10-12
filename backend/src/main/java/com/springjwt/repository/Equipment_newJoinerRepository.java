package com.springjwt.repository;

import com.springjwt.models.Equipment_newJoiner;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface Equipment_newJoinerRepository extends JpaRepository<Equipment_newJoiner, Long> {
    List<Equipment_newJoiner> findAllByNewJoinerId(Long id);
    Equipment_newJoiner findByNewJoinerIdAndAndEquipmentId(Long idJoiner, Long idEquipment);
}
