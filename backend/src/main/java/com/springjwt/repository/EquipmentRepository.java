package com.springjwt.repository;

import com.springjwt.models.Equipment;
import com.springjwt.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> getByPosition(Position position);
    //Equipment findById(Long id);
}
