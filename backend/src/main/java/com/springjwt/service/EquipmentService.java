package com.springjwt.service;

import com.springjwt.models.Equipment;
import com.springjwt.models.Position;
import com.springjwt.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public Equipment addEquipment(Equipment equipment){ return equipmentRepository.save(equipment);}

    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }
    public List<Equipment> getByPosition(Position position){
        List<Equipment> equipmentList = getAll();
        List<Equipment> equipmentFinal = new ArrayList<>();
        for (Equipment e: equipmentList) {
            if(e.getPosition().isEmpty()){
                equipmentFinal.add(e);
            }
        }
        equipmentFinal.addAll(equipmentRepository.getByPosition(position));
        return equipmentFinal;
    }
}
