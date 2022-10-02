package com.springjwt.controller;

import com.springjwt.models.Equipment;
import com.springjwt.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipment")
public class EquipmentController {
    private final EquipmentService equipmentService;

    @PostMapping
    public Equipment saveEquipment(@RequestBody Equipment equipment) {
        return equipmentService.addEquipment(equipment);
    }

    @GetMapping
    public List<Equipment> getEquipmentListByRole() {
        return equipmentService.getAll();
    }
}
