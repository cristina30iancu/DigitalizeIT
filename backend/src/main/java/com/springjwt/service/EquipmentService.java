package com.springjwt.service;

import com.springjwt.models.Equipment;
import com.springjwt.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public Equipment addEquipment(Equipment equipment){ return equipmentRepository.save(equipment);}

    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }
}
