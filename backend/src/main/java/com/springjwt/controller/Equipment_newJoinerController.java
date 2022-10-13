package com.springjwt.controller;

import com.springjwt.models.Equipment;
import com.springjwt.models.Equipment_newJoiner;
import com.springjwt.models.JwtUser;
import com.springjwt.models.NewJoiner;
import com.springjwt.service.EmailSenderService;
import com.springjwt.service.Equipment_newJoinerService;
import com.springjwt.service.NewJoinerService;
import com.springjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipmentNewJoiner")
public class Equipment_newJoinerController {

    private final Equipment_newJoinerService equipment_newJoinerService;
    private final UserService userService;
    private final EmailSenderService emailSenderService;
    private final NewJoinerService newJoinerService;
    //private final equipment_service
    @PutMapping("{newJoinerId}")
    @PreAuthorize("hasRole(ROLE_MANAGER)")
    public List<Equipment_newJoiner> addEquipment_newJoiner(@RequestBody List<Long> equipmentIdsList, @PathVariable Long newJoinerId) {
        return equipment_newJoinerService.addEquipment_newJoiner(equipmentIdsList, newJoinerId);

    }
    @GetMapping("all")
    @PreAuthorize("hasRole(ROLE_MANAGER)")
    public List<Equipment_newJoiner> getAll() {
        return equipment_newJoinerService.getAll();
    }

    @GetMapping("equipmentsOfNewjoiner/{newJoinerId}")
    @PreAuthorize("hasRole(ROLE_MANAGER)")
    public List<Equipment> getEquipmentsOfNewJoiner(@PathVariable Long newJoinerId) {
        List<Equipment_newJoiner> all = equipment_newJoinerService.getAll();
        List<Equipment> toReturn = all.stream().
                filter(en -> en.getNewJoiner().getId() == newJoinerId).
                map(en -> en.getEquipment()).collect(Collectors.toList());
        return toReturn;
    }

    @PutMapping("{idJoiner}/{idEquipment}")
    @PreAuthorize("hasRole('ROLE_IT_SUPPORT')")
    public void updateDone(@PathVariable Long idJoiner,@PathVariable Long idEquipment){
        equipment_newJoinerService.updateDone(idEquipment, idJoiner);
    }

    @DeleteMapping
    public void deleteAll() {
        equipment_newJoinerService.deleteAll();

    }
}
