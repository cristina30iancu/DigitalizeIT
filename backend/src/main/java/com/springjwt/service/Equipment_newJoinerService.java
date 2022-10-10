package com.springjwt.service;

import com.springjwt.controller.Equipment_newJoinerController;
import com.springjwt.models.Equipment;
import com.springjwt.models.Equipment_newJoiner;
import com.springjwt.models.NewJoiner;
import com.springjwt.repository.Equipment_newJoinerRepository;
import com.springjwt.repository.NewJoinerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Equipment_newJoinerService {
    private final Equipment_newJoinerRepository equipment_newJoinerRepository;
    private final NewJoinerRepository newJoinerRepository;

    public List<Equipment_newJoiner> addEquipment_newJoiner(List<Equipment> equipmentList, Long newJoinerID) {

        NewJoiner newJoiner = newJoinerRepository.findById(newJoinerID);

        List<Equipment_newJoiner> toReturn = new ArrayList<>();

        for(int i = 0; i < equipmentList.size(); ++i) {
            Equipment currEquipment = equipmentList.get(i);
            Equipment_newJoiner equipment_newJoiner = new Equipment_newJoiner(false, currEquipment, newJoiner);
            toReturn.add(equipment_newJoiner);
            equipment_newJoinerRepository.save(equipment_newJoiner);
        }

        return toReturn;
    }

    public List<Equipment_newJoiner> getAll() {
        return equipment_newJoinerRepository.findAll();
    }

    public void updateDone(Equipment_newJoiner equipment_newJoiner){
        equipment_newJoiner.setDone(true);
        NewJoiner newJoiner = equipment_newJoiner.getNewJoiner();
        List<Equipment_newJoiner> e = new ArrayList<>();
        e.addAll((Collection<? extends Equipment_newJoiner>) newJoiner.getEquipment_newJoiners().stream().filter(eq -> eq.isDone() == false));
        if(e.isEmpty()){
            newJoiner.setDone(true);
        }

        equipment_newJoinerRepository.save(equipment_newJoiner);
    }
}
