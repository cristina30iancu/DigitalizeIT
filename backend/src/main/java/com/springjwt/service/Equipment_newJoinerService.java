package com.springjwt.service;


import com.springjwt.controller.Equipment_newJoinerController;
import com.springjwt.models.Equipment;
import com.springjwt.models.Equipment_newJoiner;
import com.springjwt.models.JwtUser;
import com.springjwt.models.NewJoiner;
import com.springjwt.repository.EquipmentRepository;

import com.springjwt.repository.Equipment_newJoinerRepository;
import com.springjwt.repository.NewJoinerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.Collection;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Equipment_newJoinerService {
    private final Equipment_newJoinerRepository equipment_newJoinerRepository;
    private final NewJoinerRepository newJoinerRepository;
    private final EmailSenderService emailSenderService;
    private final NewJoinerService newJoinerService;
    private final EquipmentRepository equipmentRepository;

    public List<Equipment_newJoiner> addEquipment_newJoiner(List<Long> equipmentIdsList, Long newJoinerID) {
        NewJoiner newJoiner = newJoinerRepository.findById(newJoinerID);

        List<Equipment_newJoiner> oldEquipmentd = equipment_newJoinerRepository.findAllByNewJoinerId(newJoinerID);
        for(Equipment_newJoiner eqn : oldEquipmentd){
            equipment_newJoinerRepository.delete(eqn);
        }
        List<Equipment_newJoiner> toReturn = new ArrayList<>();

        for(int i = 0; i < equipmentIdsList.size(); ++i) {
            Equipment currEquipment = equipmentRepository.findById(equipmentIdsList.get(i)).get();
            Equipment_newJoiner equipment_newJoiner = new Equipment_newJoiner(null,false, currEquipment, newJoiner);
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
            JwtUser manager = newJoinerService.getManager(idJoiner);
            emailSenderService.sendEmail(manager.getEmail(),"DigitalizeIT", "A newJoiner is done"); //
            newJoiner.setDone(true);
            newJoinerRepository.save(newJoiner);
        }
        equipment_newJoinerRepository.save(equipment_newJoiner);
        }

    public void deleteAll() {
        equipment_newJoinerRepository.deleteAll();
    }

    public void deleteById(Long id){
        equipment_newJoinerRepository.deleteById(id);
    }

    public List<Equipment> getEquipmentsOfNewJoiner(Long newJoinerId){
        List<Equipment_newJoiner> all = getAll();
        List<Equipment> toReturn = all.stream().
                filter(en -> en.getNewJoiner().getId() == newJoinerId).
                map(en -> en.getEquipment()).collect(Collectors.toList());
        return toReturn;
    }
}
