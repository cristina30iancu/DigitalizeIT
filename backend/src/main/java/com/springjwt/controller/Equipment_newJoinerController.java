package com.springjwt.controller;

import com.springjwt.models.Equipment;
import com.springjwt.models.Equipment_newJoiner;
import com.springjwt.models.NewJoiner;
import com.springjwt.service.Equipment_newJoinerService;
import com.springjwt.service.NewJoinerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipmentNewJoiner")
public class Equipment_newJoinerController {

    private final Equipment_newJoinerService equipment_newJoinerService;
    @PutMapping("{newJoinerId}")
    public List<Equipment_newJoiner> addEquipment_newJoiner(@RequestBody List<Equipment> equipmentList,@PathVariable Long newJoinerId) {
        return equipment_newJoinerService.addEquipment_newJoiner(equipmentList, newJoinerId);
    }
    @GetMapping("all")
    public List<Equipment_newJoiner> getAll() {
        return equipment_newJoinerService.getAll();
    }
}
