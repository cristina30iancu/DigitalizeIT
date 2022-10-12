package com.springjwt.service;

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
            Equipment_newJoiner equipment_newJoiner = new Equipment_newJoiner(null, false, currEquipment, newJoiner);
            toReturn.add(equipment_newJoiner);
            equipment_newJoinerRepository.save(equipment_newJoiner);
        }

        return toReturn;
    }

    public List<Equipment_newJoiner> getAll() {
        return equipment_newJoinerRepository.findAll();
    }

    public void updateDone(Long idEquipment, Long idJoiner){
        Equipment_newJoiner equipment_newJoiner = equipment_newJoinerRepository.findByNewJoinerIdAndAndEquipmentId(idJoiner, idEquipment);
        equipment_newJoiner.setDone(true);

        List<Equipment_newJoiner> equipmentNewJoinerList = equipment_newJoinerRepository.findAllByNewJoinerId(idJoiner);
        List<Equipment_newJoiner> eq = new ArrayList<>();
        for (Equipment_newJoiner e: equipmentNewJoinerList) {
            if(e.getDone() == false) eq.add(e);
        }

        NewJoiner newJoiner = newJoinerRepository.findById(idJoiner);
        if(eq.isEmpty()){
            newJoiner.setDone(true);
            newJoinerRepository.save(newJoiner);
        }

        equipment_newJoinerRepository.save(equipment_newJoiner);
    }
}
